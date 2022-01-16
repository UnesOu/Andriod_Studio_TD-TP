package com.example.tp1_movies_application.models;

import com.google.gson.annotations.SerializedName;

public class MovieType {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String genre;

    public MovieType() {
    }

    public MovieType(String id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
