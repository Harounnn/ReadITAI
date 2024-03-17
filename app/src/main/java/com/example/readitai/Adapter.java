package com.example.readitai;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<Model> models;

    public Adapter(Context context, ArrayList<Model> models) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, sumNews.class);
                intent.putExtra("content", models.get(holder.getAdapterPosition()).getContent());
                context.startActivity(intent);
            }
        });

        holder.heading.setText(models.get(holder.getAdapterPosition()).getTitle());
        holder.description.setText(models.get(holder.getAdapterPosition()).getContent());
        Glide.with(context).load(models.get(holder.getAdapterPosition()).getUrlToImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView heading,description;
        CardView cardView;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.heading);
            description = itemView.findViewById(R.id.description);
            cardView = itemView.findViewById(R.id.cardView);
            image = itemView.findViewById(R.id.image);
        }
    }
}
