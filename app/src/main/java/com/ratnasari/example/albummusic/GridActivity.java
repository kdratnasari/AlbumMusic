package com.ratnasari.example.albummusic;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GridActivity extends RecyclerView.Adapter<GridActivity.GridViewHolder> {

    private static final String TAG = "ListView";
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mImageDesc = new ArrayList<>();
    private ArrayList<String> mImageLoc = new ArrayList<>();

    private Context mContext;

    public GridActivity(Context mContext,ArrayList<String> mImageNames, ArrayList<String> mImages, ArrayList<String> mImageDesc , ArrayList<String> mImageLoc ) {

        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mImageDesc = mImageDesc;
        this.mImageLoc = mImageLoc;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grid, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int i) {
        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(i))
                .into(holder.imgPhoto);
        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick: clicked on: "+ mImageNames.get(i));
                Toast.makeText(mContext, mImageNames.get(i),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("image_url",mImages.get(i));
                intent.putExtra("image_name",mImageNames.get(i));
                intent.putExtra("image_desc",mImageLoc.get(i));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}


