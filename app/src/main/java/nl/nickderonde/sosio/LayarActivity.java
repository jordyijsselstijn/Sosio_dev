package nl.nickderonde.sosio;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.layar.sdk.LayarSDK;


public class LayarActivity extends AppCompatActivity {

    private static final int REQUEST_FINE_LOCATION_RESULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar);


        final Context cntx = this;
        final Button btn  = (Button) findViewById(R.id.layarInitButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init(v.getContext());
            }
        });

    }

    public void init(Context cntx){

            if(ContextCompat.checkSelfPermission(cntx, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                initLayar(cntx, "xnqudWtrUJeQHCfo", "ECqLwGjiatJxsvogyWYmzXupUARZMOcB");

            }else{
                if(shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)){
                    Toast.makeText(cntx, "Fine location needed in order to use Layar", Toast.LENGTH_SHORT).show();
                }
                requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_FINE_LOCATION_RESULT);
            }

    }

    public void initLayar(Context cntx, String layarKey, String layarSecret){

        LayarSDK.initialize(cntx, layarKey, layarSecret);
        LayarSDK.startLayarActivity(cntx);
    }

    public static boolean isPermissionGranted(String permission, Context context){
        //int res = ContextCompat.checkSelfPermission(context, permission);
        return (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if(requestCode == REQUEST_FINE_LOCATION_RESULT){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                initLayar(this, "xnqudWtrUJeQHCfo", "ECqLwGjiatJxsvogyWYmzXupUARZMOcB");
            }else{
                Toast.makeText(this, "Fine location needed in order to use Layar", Toast.LENGTH_SHORT).show();
            }
        }else{
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
