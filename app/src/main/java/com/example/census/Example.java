package com.example.census;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Example extends RecyclerView.Adapter<Example.ExampleViewHolder> {
    private ArrayList<ExampleItem> myExampleList;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView myImageView;
        public TextView myTextViewLine1;
        public TextView myTextViewLine2;
        public TextView mTextViewLine3;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            myImageView = itemView.findViewById(R.id.imageView);
            myTextViewLine1 = itemView.findViewById(R.id.editName);
            myTextViewLine2 = itemView.findViewById(R.id.editAge);
            mTextViewLine3 = itemView.findViewById(R.id.gender);
        }
    }

    public Example(ArrayList<ExampleItem> exampleList) {
        myExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder exampleViewHolder = new ExampleViewHolder(v);
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        ExampleItem currentItem = myExampleList.get(position);
        Bitmap bitmap;
        String previouslyEncodedImage = currentItem.getImageResource();
        if( !previouslyEncodedImage.equalsIgnoreCase("") ){
            byte[] b = Base64.decode(previouslyEncodedImage, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(b, 0, b.length);
            holder.myImageView.setImageBitmap(bitmap);
        }
        holder.myTextViewLine1.setText(currentItem.getLine1());
        holder.myTextViewLine2.setText(currentItem.getLine2());
        holder.mTextViewLine3.setText(currentItem.getLine3());
    }

    @Override
    public int getItemCount() {
        return myExampleList.size();
    }
}
