package com.example.tp1_movies_application.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieInfoModel {

    @SerializedName("id")
    private String id;

    @SerializedName("overview")
    private String description;

    @SerializedName("original_title")
    private String title;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("backdrop_path")
    private String image;

    @SerializedName("genres")
    private List<MovieType> movieTypes;

    public MovieInfoModel() {
    }

    public MovieInfoModel(String id, String description, String title, String releaseDate, String image, List<MovieType> movieTypes) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.releaseDate = releaseDate;
        this.image = image;
        this.movieTypes = movieTypes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<MovieType> getMovieTypes() {
        return movieTypes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMovieTypes(List<MovieType> movieTypes) {
        this.movieTypes = movieTypes;
    }
}
