package com.example.kulozubeste;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class jsonAdapter extends RecyclerView.Adapter<jsonAdapter.MyViewClass> {

    ArrayList<String> id;
    ArrayList<String> headline;
    ArrayList<String> context;
    ArrayList<String> content;

    Context msg;

    public jsonAdapter(ArrayList<String> id, ArrayList<String> headline, ArrayList<String> context, ArrayList<String> content, ThirdActivity thirdActivity){
        this.id = id;
        this.headline = headline;
        this.context = context;
        this.content = content;
        this.msg = msg;
    }


    @NonNull
    @Override
    public MyViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent, false);
        MyViewClass myViewClass = new MyViewClass(view);

        return myViewClass;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewClass holder, int position) {
        holder.id.setText(id.get(position));
        holder.headline.setText(headline.get(position));
        holder.context.setText(context.get(position));
        holder.content.setText(content.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Toast.makeText(msg, "item clicked",)
            }
        });


    }

    @Override
    public int getItemCount() {
        return id.size();

    }

    public class MyViewClass extends RecyclerView.ViewHolder {

        TextView id;
        TextView headline;
        TextView context;
        TextView content;

        public MyViewClass(@NonNull View itemView){
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.id);
            headline = (TextView) itemView.findViewById(R.id.headline);
            context = (TextView) itemView.findViewById(R.id.context);
            content = (TextView) itemView.findViewById(R.id.content);

        }
    }
}
