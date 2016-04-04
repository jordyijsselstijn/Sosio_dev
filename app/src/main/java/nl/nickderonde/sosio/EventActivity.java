package nl.nickderonde.sosio;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Challenge[] challenges= new Challenge[]{          new Challenge(1, R.drawable.challenge_1, "Recruit 4 new people for this challenge", "and add them with layar", "20"),
                new Challenge(2, R.drawable.challenge_2, "Take a picture with a dutch cheese", "and upload it to SOSIO", "20"),
                new Challenge(3, R.drawable.challenge_3, "Rent a tendem", "and cycle for 25 minutes", "30")};


        final ListView lv = (ListView) findViewById(R.id.challengeList);
        challengeAdapter adapter = new challengeAdapter(this, challenges );

        lv.setAdapter(adapter);

    }
    public class challengeAdapter extends ArrayAdapter<Challenge>{

        private final Context context;
        private final Challenge[] challenges;

        public challengeAdapter(Context context, Challenge[] challenges){
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
            TextView pointTotal = (TextView) rowView.findViewById(R.id.pointTotal);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.challengeImage);


            challengeTitle.setText(challenges[position].getTitle());
            challengeDescription.setText(challenges[position].getDescription());
            pointTotal.setText(challenges[position].getPoints());
            imageView.setImageResource(challenges[position].getImagePath());

            return rowView;
        }
    }

}