package com.example.tp1_movies_application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tp1_movies_application.models.MovieInfoModel;
import com.example.tp1_movies_application.models.MovieType;
import com.example.tp1_movies_application.services.MovieResponse;
import com.example.tp1_movies_application.services.MovieService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieInfo extends AppCompatActivity {
    private String idMovie;
    private MovieInfoModel movieInfoModel = new MovieInfoModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);


        if (getIntent().hasExtra("movie_id")) {
            idMovie = getIntent().getStringExtra("movie_id");
            Log.d("movieInfo", "Movie id is: " + idMovie);
        }

        getMovieInfo();
    }


    private void getMovieInfo() {
        MovieService movieService = new Retrofit.Builder()
                .baseUrl(MovieService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieService.class);

        Call<MovieInfoModel> call = movieService.movieDescription(Integer.parseInt(idMovie),"dbd6335317217b32317f8cb921c632d5");
        Context context = this;
        call.enqueue(new Callback<MovieInfoModel>() {
            @Override
            public void onResponse(Call<MovieInfoModel> call, Response<MovieInfoModel> response) {

                movieInfoModel = response.body();
                System.out.println("hna"+movieInfoModel.getMovieTypes().get(1).getGenre());
                setData(movieInfoModel);
            }

            @Override
            public void onFailure(Call<MovieInfoModel> call, Throwable t) {
                Toast.makeText(context, t.toString(),Toast.LENGTH_SHORT).show(); // ALL NETWORK ERROR HERE

            }
        });
    }


    private void setData(MovieInfoModel movieInfoModel) {
        setTitle(movieInfoModel.getTitle());
        ImageView imageView;
        TextView title;
        TextView description;
        TextView genre;
        TextView releaseDate;

        imageView = findViewById(R.id.imageInfo);
        title = findViewById(R.id.movieTitle);
        description = findViewById(R.id.movieDescription);
        genre = findViewById(R.id.movieGenres);
        releaseDate = findViewById(R.id.releaseDate);


        Glide.with(this)
                .load("https://image.tmdb.org/t/p/original/"+movieInfoModel.getImage())
                .into(imageView);


        title.setText(movieInfoModel.getTitle());
        description.setText(movieInfoModel.getDescription());
        releaseDate.setText(movieInfoModel.getReleaseDate());
        List<MovieType> types = movieInfoModel.getMovieTypes();

        for (MovieType type: types) {
            genre.append(type.getGenre() + "\r\n");

        }

    }
}