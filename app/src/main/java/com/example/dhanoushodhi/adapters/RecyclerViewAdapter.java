package com.example.dhanoushodhi.adapters;

import android.content.Context;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
import android.widget.Toast;

import com.example.dhanoushodhi.DetailsActivity;
import com.example.dhanoushodhi.HomeActivity;
import com.example.dhanoushodhi.R;
import com.example.dhanoushodhi.SplashScreenActivity;
import com.example.dhanoushodhi.UploadImagesActivity;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Integer> mImage;
    private ArrayList<String> mDiseaseName = new ArrayList<>();
    private Context mContext;
    private String category;

    public RecyclerViewAdapter(ArrayList<Integer> mImage, ArrayList<String> mDiseaseName, String category, Context mContext) {
        this.mImage = mImage;
        this.mDiseaseName = mDiseaseName;
        this.category = category;
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
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        /*Log.d(TAG, "onBindHolder called.   --> " + mContext);*/

        viewHolder.image.setImageBitmap(decodeSampledBitmapFromResource(mContext.getResources(), mImage.get(i), 100, 100));
        viewHolder.diseaseName.setText(mDiseaseName.get(i));

        viewHolder.btn_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra("diseaseName", mDiseaseName.get(i));
                mContext.startActivity(intent);
            }
        });

        viewHolder.btn_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, UploadImagesActivity.class);
                intent.putExtra("diseaseName", mDiseaseName.get(i));
                intent.putExtra("category", category);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDiseaseName.size();
    }


    /*  Resizing image  */
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    /*  Resizing image  @END*/




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
