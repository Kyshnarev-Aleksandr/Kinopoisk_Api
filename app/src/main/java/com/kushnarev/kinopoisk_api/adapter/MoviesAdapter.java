package com.kushnarev.kinopoisk_api.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kushnarev.kinopoisk_api.R;
import com.kushnarev.kinopoisk_api.activity.Film_Activity_Click;
import com.kushnarev.kinopoisk_api.pojo.Film;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {


    private List<Film> filmList;
    Context mContext;

    public MoviesAdapter(List<Film> filmList, Context mContext) {
        this.filmList = filmList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(filmList.get(position).getTitle());

        Picasso.get().load("http:" + filmList.get(position).getPoster()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Film_Activity_Click.class);
                intent.putExtra("Title", filmList.get(position).getTitle());
                intent.putExtra("description", filmList.get(position).getDescription());
                intent.putExtra("year", filmList.get(position).getYear());
                intent.putExtra("poster", "http:" + filmList.get(position).getPoster());
                intent.putExtra("premiere_world", filmList.get(position).getPremiere_world());
                intent.putExtra("rating", filmList.get(position).getRating_kinopoisk());
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.image_view);

        }
    }


}
