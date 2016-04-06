package nl.jordyijsselstijn.sosio_dev;

import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.layar.sdk.LayarSDKClient;
import com.layar.sdk.data.Action;
import com.layar.sdk.data.Layer;
import com.layar.sdk.data.Poi;

/**
 * Created by jordyijsselstijn on 04-04-16.
 */
public class Callback extends LayarSDKClient {

    private boolean needsResetScanMode = false;

    @Override
    public boolean shouldTriggerAction(Layer layer, Poi poi, Action action){

        Uri uri = Uri.parse(action.getUri());

        if("layar".equals(uri.getScheme())){
            needsResetScanMode = true;

            String layerName = uri.getAuthority();

            getSdkFragment().openLayer(layerName);
            return false;
        }

        return true;
    }

    @Override
    public boolean onBackPressed(){
        if(needsResetScanMode && !getSdkFragment().isInScanMode()){
            needsResetScanMode = false;

            getSdkFragment().openScanMode();
            return true;
        }
        return false;
    }

}
