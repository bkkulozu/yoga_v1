package com.example.yogafitclass;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ImageViewHolder> {

    private int[] images;

    public RecyclerAdapter(int[] images) {
        this.images = images;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.yoga_layout, parent, false);
        ImageViewHolder imageViewHolder = new ImageViewHolder((view));

        return imageViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        int image_id = images[position];
       holder.yogas.setImageResource(image_id);

    }

    @Override
    public int getItemCount()  {
        return images.length;
    }


    public static class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView yogas;
       // TextView yogas_title;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            yogas = itemView.findViewById(R.id.yogas);
           // yogas_title = itemView.findViewById(R.id.yogas_title);


        }
    }

    public class MyViewHolder {
    }
}
