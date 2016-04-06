package nl.jordyijsselstijn.sosio_dev;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class ChallengeDetailActivity extends AppCompatActivity {


    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        ListView lv = (ListView) findViewById(R.id.challengeDescriptionListView);
        ChallengeInstruction[] challengeInstructions = {
                new ChallengeInstruction("By scanning the Ibis object you can discover what other SOSIO's liked to do during their stay in Rotterdam", "Use the layar button below to scan the object.", R.drawable.light_bulb),
                new ChallengeInstruction("By scanning the Ibis object you can discover what other SOSIO's liked to do during their stay in Rotterdam", "Use the layar button below to scan the object.", R.drawable.light_bulb)
        };

        lv.setAdapter(new ChallengeInstuctionListAdapter(this, challengeInstructions));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });

    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Log.d("########", "IMAGE CAPTURED!"+ new Date().getTime());
            Intent goToResultPage = new Intent(this, ChallengeResultActivity.class);
            startActivity(goToResultPage);
        }
    }

    public class ChallengeInstuctionListAdapter extends ArrayAdapter<ChallengeInstruction> {

        private final Context context;
        private final ChallengeInstruction[] instructions;


        public ChallengeInstuctionListAdapter(Context context, ChallengeInstruction[] instructions){
            super(context, -1, instructions);
            this.context = context;
            this.instructions = instructions;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.challenge_instruction_view, parent, false);

            TextView instructionTitle = (TextView) rowView.findViewById(R.id.challengeDescriptionTitle);
            TextView instructionDescription = (TextView) rowView.findViewById(R.id.challengeDescriptionText);
            ImageView instructionImage = (ImageView) rowView.findViewById(R.id.challengeDescriptionImage);



            instructionTitle.setText(instructions[position].getTitle());
            instructionDescription.setText(instructions[position].getDescription());
            instructionImage.setImageResource(instructions[position].getImagePath());


            return rowView;
        }
    }

}
