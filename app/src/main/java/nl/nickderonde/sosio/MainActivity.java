package nl.nickderonde.sosio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Event> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_main);

        eventList = new ArrayList<Event>();

        eventList.add(new Event(1, "Erasmusbrug", R.drawable.erasmusbrug, false));
        eventList.add(new Event(2, "Markthal", R.drawable.markthal, false));
        eventList.add(new Event(3, "Splashbus", R.drawable.splashbus, false));
        eventList.add(new Event(4, "Erasmusbrug", R.drawable.erasmusbrug, false));
        eventList.add(new Event(5, "Markthal", R.drawable.markthal, false));
        eventList.add(new Event(6, "Splashbus", R.drawable.splashbus, false));

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        RVAdapter adapter = new RVAdapter(eventList, this, new RVAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                eventList.get(position);
            }
        });
        rv.setAdapter(adapter);
    }

}
