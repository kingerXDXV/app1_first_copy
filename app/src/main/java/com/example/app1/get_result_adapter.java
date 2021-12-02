package com.example.app1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class get_result_adapter extends RecyclerView.Adapter<get_result_adapter.MyViewHolder> {

    Context context;
    ArrayList<model_data_result_firebase> model_data_result_firebaseArrayList;

    public get_result_adapter(Context context, ArrayList<model_data_result_firebase> model_data_result_firebaseArrayList) {
        this.context = context;
        this.model_data_result_firebaseArrayList = model_data_result_firebaseArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.results_display,parent,false);

        return new MyViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        model_data_result_firebase model_data_result_firebase_obj = model_data_result_firebaseArrayList.get(position);
        holder.display.setText("Subject : "+model_data_result_firebase_obj.subject+"\nDifficulty : "+model_data_result_firebase_obj.level+"\nMarks : "+model_data_result_firebase_obj.marks+"\nQuestion Skipped : "+model_data_result_firebase_obj.skip);
    }

    @Override
    public int getItemCount() {
        return model_data_result_firebaseArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView display;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
                display=itemView.findViewById(R.id.ids_play);
        }
    }
}
