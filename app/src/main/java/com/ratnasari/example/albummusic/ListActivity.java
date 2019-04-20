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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListActivity extends RecyclerView.Adapter<ListActivity.ViewHolder> {

    private static final String TAG = "ListView";

    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mImageDesc = new ArrayList<>();
    private ArrayList<String> mImageLoc = new ArrayList<>();

    private Context mContext;

    public ListActivity(Context mContext,ArrayList<String> mImageNames, ArrayList<String> mImages, ArrayList<String> mImageDesc , ArrayList<String> mImageLoc ) {
        this.mImageNames = mImageNames;
        this.mImages = mImages;
        this.mImageDesc = mImageDesc;
        this.mImageLoc = mImageLoc;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        Log.d(TAG,"onBindViewHolder: called.");

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(i))
                .into(holder.image);
        holder.imageName.setText(mImageNames.get(i));
        holder.imageDesc.setText(mImageDesc.get(i));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
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
        return mImageNames.size();
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView imageName;
        TextView imageDesc;
        RelativeLayout parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.gambar);
            imageName = itemView.findViewById(R.id.nama);
            imageDesc = itemView.findViewById(R.id.deskripsi);
            parentLayout = itemView.findViewById(R.id.list);
        }
    }
}
