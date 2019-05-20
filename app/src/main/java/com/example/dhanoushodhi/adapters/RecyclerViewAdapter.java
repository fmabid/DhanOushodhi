package com.example.dhanoushodhi.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dhanoushodhi.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Integer> mImage;
    private ArrayList<String> mDiseaseName = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<Integer> mImage, ArrayList<String> mDiseaseName, Context mContext) {
        this.mImage = mImage;
        this.mDiseaseName = mDiseaseName;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindHolder called.");

        viewHolder.image.setImageResource(R.drawable.bakani);
        Log.d(TAG, "onBindViewHolder called  --->  " + mImage.get(i));
        viewHolder.diseaseName.setText(mDiseaseName.get(i));

        /*viewHolder.image.setImageDrawable(Drawable.createFromPath(mImage.get(i)));*/
    }

    @Override
    public int getItemCount() {
        return mDiseaseName.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView diseaseName;
        RelativeLayout parentLayout;
        Button btn_select;
        Button btn_details;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.iv_image);
            diseaseName = itemView.findViewById(R.id.tv_disease_name);
            parentLayout = itemView.findViewById(R.id.rl_parent);
            btn_select = itemView.findViewById(R.id.btn_select);
            btn_details = itemView.findViewById(R.id.btn_details);
        }
    }
}