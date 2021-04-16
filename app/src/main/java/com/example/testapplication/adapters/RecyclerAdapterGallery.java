package com.example.testapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.R;

import java.util.List;

public class RecyclerAdapterGallery extends RecyclerView.Adapter<RecyclerAdapterGallery.ImageViewHolder> {

    private List<Gallery> personList;

    public RecyclerAdapterGallery(List<Gallery> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_layout,parent,false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Gallery person = personList.get(position);
        holder.imageView.setImageResource(person.getImage());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView imageView;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.gallery_sport);
        }
    }
}
