package com.example.tp1_movies_application.services;

import com.example.tp1_movies_application.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {
    @SerializedName("results")
    @Expose
    private List<MovieModel> movieModelList;


    public List<MovieModel> getPopularMovies() {
        return movieModelList;
    }

}
