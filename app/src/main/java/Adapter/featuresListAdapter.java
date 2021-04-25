package Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yogafitclass.R;
import com.example.yogafitclass.SecondActivity;

import Models.featuresListModel;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class featuresListAdapter extends RecyclerView.Adapter<featuresListAdapter.ViewHolder> {
    private featuresListModel[] featuresListModels;
    private SecondActivity context;

    public featuresListAdapter(featuresListModel[] featuresListModels, SecondActivity context) {
        this.featuresListModels = featuresListModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.useful_features_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final featuresListModel myListData = featuresListModels[position];
        holder.name.setText(featuresListModels[position].getName());
        holder.logo.setImageResource(featuresListModels[position].getLogo());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, myListData.getName(), Toast.LENGTH_SHORT).show();
                context.openCountdownActivity(featuresListModels[position].getName(),featuresListModels[position].getLogo());
            }
        });

    }

    @Override
    public int getItemCount() {
        return featuresListModels.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name;
        public ImageView logo;
        public RelativeLayout relativeLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.yname);
            logo = itemView.findViewById(R.id.logo);
            relativeLayout = itemView.findViewById(R.id.feature_list);


        }
    }


}
