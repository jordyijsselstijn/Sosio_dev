package nl.nickderonde.sosio;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jordyijsselstijn on 29-03-16.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.EventViewHolder>{

    List<Event> events;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    RVAdapter(List<Event> events, Context context, OnItemClickListener listener){

        this.events = events;
        this.context = context;
        this.listener = listener;
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView eventTitle;
        ImageView eventImage;


        EventViewHolder(View itemView) {
            super(itemView);

            cv = (CardView)itemView.findViewById(R.id.cv);
            eventTitle = (TextView)itemView.findViewById(R.id.event_title);
            eventImage = (ImageView)itemView.findViewById(R.id.event_image);
        }


    }
    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view, viewGroup, false);
        final EventViewHolder pvh = new EventViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, pvh.getLayoutPosition());
            }
        });
        return pvh;
    }
    @Override
    public int getItemCount() {
        return events.size();
    }

    @Override
    public void onBindViewHolder(EventViewHolder eventViewHolder, int i) {
        eventViewHolder.eventTitle.setText(events.get(i).getTitle());
        eventViewHolder.eventImage.setImageResource(events.get(i).getImagePath());

    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}