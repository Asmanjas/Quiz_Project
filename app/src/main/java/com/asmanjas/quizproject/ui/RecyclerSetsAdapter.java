package com.asmanjas.quizproject.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.asmanjas.quizproject.R;

public class RecyclerSetsAdapter extends RecyclerView.Adapter<RecyclerSetsAdapter.MyOwnHolder> {

    private Context context;
    private int numberOfSets;


    public RecyclerSetsAdapter(Context context, int numberOfSets) {
        this.context = context;
        this.numberOfSets = numberOfSets;
    }

    @NonNull
    @Override
    public MyOwnHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View v =  LayoutInflater.from(context).inflate(R.layout.recycler_card_for_sets,parent,false);
        return new MyOwnHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyOwnHolder holder, int position) {
        holder.setNameTextView.setText("Set" + (position+1));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_aptitudeFragment_to_questionDisplayFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return numberOfSets;
    }

    public class MyOwnHolder extends RecyclerView.ViewHolder {

        TextView setNameTextView;
        CardView cardView;

        public MyOwnHolder(@NonNull View itemView) {
            super(itemView);
            setNameTextView  = itemView.findViewById(R.id.set_name_text_view);
            cardView = itemView.findViewById(R.id.recycler_card_view);
        }
    }
}
