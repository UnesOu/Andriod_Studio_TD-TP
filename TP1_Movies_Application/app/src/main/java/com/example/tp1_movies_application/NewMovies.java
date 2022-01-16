package com.example.tp1_movies_application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tp1_movies_application.adapters.MovieAdapter;
import com.example.tp1_movies_application.models.MovieModel;
import com.example.tp1_movies_application.services.MovieService;
import com.example.tp1_movies_application.services.MovieResponse;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewMovies extends AppCompatActivity implements MovieAdapter.OnMovieListener {

    List<MovieModel> moviesList;
    RecyclerView recyclerView;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_movies);
        setTitle("New Movies");

        //Initialize and assign variable
        BottomNavigationView navView = findViewById(R.id.nav_view);

        //Set Home Selected
        navView.setSelectedItemId(R.id.navigation_new_movies);

        //Perform ItemSelectedListener
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.navigation_popular_movie:
                        Intent i = new Intent(NewMovies.this, PopularMovies.class);
                        startActivity(i);
                        finish();
                        return true;

                    case R.id.navigation_new_movies:
                        return true;
                }
                return false;
            }
        });

        intent = getIntent();
        moviesList = new ArrayList<>();
        recyclerView = findViewById(R.id.new_movies_recyclerView);
        GetUpcomingMovies();
    }



    private void GetUpcomingMovies() {
        MovieService movieService = new Retrofit.Builder()
                .baseUrl(MovieService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieService.class);


        Call<MovieResponse> call = movieService.listUpcomingMovies("dbd6335317217b32317f8cb921c632d5");
        Context context = this;
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse movieResponse = (MovieResponse) response.body();
                moviesList = movieResponse.getPopularMovies();
                System.out.println("hna"+moviesList.size());
                PutDataInRecyclerView(moviesList);

            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(context, t.toString(),Toast.LENGTH_SHORT).show(); // ALL NETWORK ERROR HERE

            }
        });
    }

    private void PutDataInRecyclerView(List<MovieModel> movies) {

        MovieAdapter movieAdapter = new MovieAdapter(this, movies,this);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        recyclerView.setAdapter(movieAdapter);
    }

    @Override
    public void onMovieClick(int position) {
        String id = moviesList.get(position).getId();
        Intent intent = new Intent(this, MovieInfo.class);
        intent.putExtra("movie_id", id);
        startActivity(intent);
    }
}