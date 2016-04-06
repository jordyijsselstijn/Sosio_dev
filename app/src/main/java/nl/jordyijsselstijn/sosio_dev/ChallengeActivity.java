package nl.jordyijsselstijn.sosio_dev;

import android.content.Context;
import android.content.Intent;
import android.database.CursorJoiner;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ChallengeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        final Challenge[] challenges = {

                new Challenge(1,R.drawable.moccamore, "Scan the Ibis Object", "And discover what other people like to do in Rotterdam", "4"),
                new Challenge(2,R.drawable.moccamore, "Visit the Euromast", "And scan the building to claim your points", "2")
        };

        ListView lv = (ListView) findViewById(R.id.challengeListView);
        lv.setAdapter(new ChallengeAdapter(this, challenges));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                Intent goToChallenge = new Intent(ChallengeActivity.this, ChallengeDetailActivity.class);
                startActivity(goToChallenge);
            }

        });


    }


    public class ChallengeAdapter extends ArrayAdapter<Challenge>{

        private Context context;
        private Challenge[] challenges;


        public ChallengeAdapter(Context context, Challenge[] challenges){
            super(context, -1, challenges);

            this.context = context;
            this.challenges = challenges;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.challenge_view, parent, false);

            TextView challengeTitle = (TextView) rowView.findViewById(R.id.challengeTitle);
            TextView challengeDescription = (TextView) rowView.findViewById(R.id.challengeDescription);
            TextView challengePoints = (TextView) rowView.findViewById(R.id.pointTotal);
            ImageView challengeImage = (ImageView) rowView.findViewById(R.id.challengeImage);


            challengeTitle.setText(challenges[position].getTitle());
            challengeDescription.setText(challenges[position].getDescription());
            challengePoints.setText(challenges[position].getPoints());
            challengeImage.setImageResource(challenges[position].getImagePath());

            return rowView;
        }
    }

}
