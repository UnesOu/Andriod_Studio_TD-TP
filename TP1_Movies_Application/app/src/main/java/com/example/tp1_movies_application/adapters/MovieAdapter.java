package com.example.tp1_movies_application.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tp1_movies_application.R;
import com.example.tp1_movies_application.models.MovieModel;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private Context mContext;
    private List<MovieModel> movies;
    private OnMovieListener mOnMovieListener;

    public MovieAdapter(Context mContext, List<MovieModel> movies, OnMovieListener onMovieListener) {
        this.mContext = mContext;
        this.movies = movies;
        this.mOnMovieListener = onMovieListener;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.movie_item, parent, false);

        return new MyViewHolder(view, mOnMovieListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.id.setText(movies.get(position).getId());
        holder.name.setText(movies.get(position).getName());
        System.out.println("hna1: " + movies.get(position).getName());
        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/original/"+movies.get(position).getImage())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView id;
        TextView name;
        ImageView image;

        OnMovieListener onMovieListener;

        public MyViewHolder(@NonNull View itemView, OnMovieListener onMovieListener) {
            super(itemView);
            id = itemView.findViewById(R.id.id_text);
            name = itemView.findViewById(R.id.movieName_txt);
            image = itemView.findViewById(R.id.MovieImgView);
            this.onMovieListener = onMovieListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onMovieListener.onMovieClick(getAdapterPosition());
        }
    }

    public interface OnMovieListener {
        void onMovieClick(int position);
    }
}
