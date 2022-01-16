package com.example.tp1_movies_application.services;

import com.example.tp1_movies_application.models.MovieInfoModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {
    public static final String ENDPOINT = "https://api.themoviedb.org/3/movie/";
    static final String apiKey = "dbd6335317217b32317f8cb921c632d5";


    @GET("popular")
    Call<MovieResponse> listPopularMovies(@Query("api_key") String apiKey);


    @GET("upcoming")
    Call<MovieResponse> listUpcomingMovies(@Query("api_key") String apiKey);


    @GET("{movie_id}")
    Call<MovieInfoModel> movieDescription(@Path("movie_id")int movie_id, @Query("api_key")String apiKey);
}
