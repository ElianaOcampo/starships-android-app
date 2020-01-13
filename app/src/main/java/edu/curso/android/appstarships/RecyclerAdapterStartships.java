package edu.curso.android.appstarships;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.curso.android.appstarships.entity.StarshipDataApi;

public class RecyclerAdapterStartships extends RecyclerView.Adapter<RecyclerAdapterStartships.StartshipViewHolder> {

    private Context context;
    private ArrayList<StarshipDataApi> starships;
    private onClickListener onClickListener;

    public RecyclerAdapterStartships(Context context, ArrayList<StarshipDataApi> starshipDataApi, onClickListener onClickListener) {
        this.context = context;
        this.starships = starshipDataApi;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerAdapterStartships.StartshipViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_item_startship, parent,false);
        return new StartshipViewHolder(view, onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull StartshipViewHolder holder, int position) {
        holder.textViewName.setText("Name: " + starships.get(position).getName());
        holder.textViewModel.setText("Model: " + starships.get(position).getModel());
    }

    @Override
    public int getItemCount() {
        if(starships != null) {
            return starships.size();
        }
        return 0;
    }

    public class StartshipViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewName;
        TextView textViewModel;
        onClickListener listener;

        public StartshipViewHolder(View itemView, onClickListener listener) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.textViewNameItem);
            textViewModel = (TextView)itemView.findViewById(R.id.textViewModelItem);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClickListener(getAdapterPosition());
        }
    }

    public interface onClickListener {
        public void onClickListener(int pos);
    }

}
