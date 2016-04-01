package nl.jordyijsselstijn.sosio_dev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Event> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_main);

        eventList = new ArrayList<Event>();

        eventList.add(new Event(1, "Erasmus Brug", R.drawable.erasmusbrug, false));
        eventList.add(new Event(2, "Markt Hal", R.drawable.markthal, false));
        eventList.add(new Event(3, "Splash Bus", R.drawable.splashbus, false));
        eventList.add(new Event(4, "Erasmus Brug", R.drawable.erasmusbrug, false));
        eventList.add(new Event(5, "Markt Hal", R.drawable.markthal, false));
        eventList.add(new Event(6, "Splash Bus", R.drawable.splashbus, false));

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        RVAdapter adapter = new RVAdapter(eventList);
        rv.setAdapter(adapter);
    }
}
