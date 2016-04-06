package nl.jordyijsselstijn.sosio_dev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChallengeResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_result);

        final Button goToChallenges = (Button) findViewById(R.id.backToChallengesButton);
        final Button spendPoints = (Button) findViewById(R.id.spendPointsButton);

        goToChallenges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(ChallengeResultActivity.this, ChallengeActivity.class);
                startActivity(activity);
            }
        });
        spendPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity = new Intent(ChallengeResultActivity.this, profileActivity.class);
                startActivity(activity);
            }
        });




    }
}
