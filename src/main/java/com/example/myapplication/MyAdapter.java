package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyviewHolder>{

     ArrayList<Movie> movies=new ArrayList<>();
    public static final String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w185";
    // private MyListener listener;


    public MyAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }


    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view;
         view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
         return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        Movie movie=movies.get(position);
        holder.header.setText(movie.getTitle());
        holder.subheader.setText(movie.getRelease_date());
        Picasso.with(holder.image.getContext()).load(IMAGE_BASE_URL+movie.getPoster_path()).into(holder.image);
         holder.itemView.setOnClickListener(view -> {
             Intent intent=new Intent(holder.itemView.getContext(),MainActivity2.class);
             Bundle bundle = new Bundle();
             bundle.putString("title", movie.getTitle());
             bundle.putString("details", movie.getOverview());
             bundle.putString("image",movie.getPoster_path());
             intent.putExtras(bundle);
             holder.itemView.getContext().startActivity(intent);

    });

   }

    @Override
    public int getItemCount() {
        return movies==null?0:movies.size();
    }

     static class MyviewHolder extends RecyclerView.ViewHolder{
         TextView header;
         TextView subheader;
         ImageView image;

         public MyviewHolder(@NonNull View itemView) {
             super(itemView);
             intUI(itemView);
         }
         private void intUI(View itemView) {
             header = itemView.findViewById(R.id.header);
             subheader = itemView.findViewById(R.id.sub);
             image = itemView.findViewById(R.id.imageView);

         }
     }
    public void setData(ArrayList<Movie> data) {
        if (movies != null) {
            movies.clear();
            movies.addAll(data);
            notifyDataSetChanged();
        }
    }

}