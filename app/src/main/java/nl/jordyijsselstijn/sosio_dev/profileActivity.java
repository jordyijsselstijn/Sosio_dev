package nl.jordyijsselstijn.sosio_dev;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class profileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView lv = (ListView) findViewById(R.id.rewardListView);
        Reward[] rewards = new Reward[]{
                new Reward("Free coffee", "@Moccamore", "20", R.drawable.moccamore),
                new Reward("1 Free night", "@Hotel Ibis Amsterdam","250" ,R.drawable.ibis)
        };
        rewardListAdapter adapter = new rewardListAdapter(this, rewards);
        assert lv != null;
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


    }

    public class rewardListAdapter extends ArrayAdapter<Reward>{

        private final Context context;
        private final Reward[] rewards;


        public rewardListAdapter(Context context, Reward[] rewards){
            super(context, -1, rewards);
            this.context = context;
            this.rewards = rewards;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.reward_view, parent, false);

            TextView rewardTitle = (TextView) rowView.findViewById(R.id.rewardTitle);
            TextView rewardCost = (TextView) rowView.findViewById(R.id.rewardCost);
            TextView rewardlocation = (TextView) rowView.findViewById(R.id.rewardLocation);
            ImageView rewardImage = (ImageView) rowView.findViewById(R.id.rewardImage);



            rewardTitle.setText(rewards[position].getTitle());
            rewardCost.setText(rewards[position].getCost());
            rewardlocation.setText(rewards[position].getLocation());
            rewardImage.setImageResource(rewards[position].getImagePath());
            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goToSpending = new Intent(profileActivity.this, SpendActivity.class);
                    startActivity(goToSpending);
                }
            });

            return rowView;
        }
    }


}
