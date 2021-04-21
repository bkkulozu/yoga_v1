package com.example.yogafitclass;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyRecyclerViewItemHolder> {
    private Context context;
    private ArrayList<Yogi> recyclerItemValues;

    DatabaseHelper dbHelper;
    public MyRecyclerViewAdapter(Context context, ArrayList<Yogi> values){
        this.context = context;
        this.recyclerItemValues = values;
        dbHelper = new DatabaseHelper(context);
    }

    @NonNull
    @Override
    public MyRecyclerViewItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflator = LayoutInflater.from(viewGroup.getContext());

        View itemView = inflator.inflate(R.layout.recycler_item, viewGroup, false);

        MyRecyclerViewItemHolder mViewHolder = new MyRecyclerViewItemHolder(itemView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewItemHolder myRecyclerViewItemHolder, int i) {

        final Yogi YogiItem = recyclerItemValues.get(i);

        myRecyclerViewItemHolder.tvItemName.setText(YogiItem.getName());
        myRecyclerViewItemHolder.tvItremPrice.setText(YogiItem.getPrice()+" TL");

        String imageAddress= "http://ctlkent.edu.tr/ctis487/Yogis/"+YogiItem.getImage();
        /*
        How to use picasso: https://code.tutsplus.com/tutorials/android-sdk-working-with-picasso--cms-22149
        Picasso is an image library for Android. It's created and maintained by Square,
        and caters to image loading and processing.
        */


        Picasso.with(context)
                .load(imageAddress)
                .resize(80, 80)
                .rotate(180)
                .error(R.mipmap.ic_launcher)
                .into(myRecyclerViewItemHolder.imgItemYogiImage);


        Log.d("IMAGE", "http://ctis.bilkent.edu.tr/ctis487/Yogis/"+YogiItem.getImage());

        /*Or use Glide
        https://www.raywenderlich.com/2945946-glide-tutorial-for-android-getting-started
        Glide is a fast and efficient open source media management and image loading framework for
        Android that wraps media decoding, memory and disk caching, and resource pooling into
        a simple and easy to use interface. Glide supports fetching, decoding, and displaying video
        stills, images, and animated GIFs.

        Also to the manifest add internet permission
        +
        to the application tag add   android:usesCleartextTraffic="true"
        */

        Glide.with(context)
                .load(imageAddress)//Load the url
                .centerCrop()//photo fully fills the ImageView
                .placeholder(R.mipmap.ic_launcher)//Provide an image resource as a placeholder before Glide starts loading the image.
                .error(R.mipmap.ic_launcher)//Provide an image resource as an error placeholder when Glide is unable to load the image.
                .fallback(R.mipmap.ic_launcher)//Use fallback image resource when the url can be null
                .into(myRecyclerViewItemHolder.imgItemYogiImage) ;//Set the ImageView of PhotoViewHolder as the target.

        myRecyclerViewItemHolder.parentLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                boolean res = YogiDB.delete(dbHelper,YogiItem.getId()+"");

                if(res) {
                    Toast.makeText(context, "delete done", Toast.LENGTH_SHORT).show();
                    refreshMyAdapterAfterDelete(i);
                }else{
                    Toast.makeText(context, "delete can not be done", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
    public void refreshMyAdapterAfterDelete(int position){
        //recyclerItemValues = YogiDB.getAllYogi(dbHelper);
        recyclerItemValues.remove(position);
        notifyItemRemoved(position);
        //notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return recyclerItemValues.size();
    }

    class MyRecyclerViewItemHolder extends  RecyclerView.ViewHolder{
        TextView tvItemName, tvItremPrice;
        ImageView imgItemYogiImage;
        ConstraintLayout parentLayout;
        public MyRecyclerViewItemHolder(@NonNull View itemView) {
            super(itemView);
            tvItemName = itemView.findViewById(R.id.tvItemYogiName);
            tvItremPrice = itemView.findViewById(R.id.tvItemYogiPrice);
            imgItemYogiImage = itemView.findViewById(R.id.imgItemYogimage);
            parentLayout = itemView.findViewById(R.id.itemConstLayout);
        }
    }

}