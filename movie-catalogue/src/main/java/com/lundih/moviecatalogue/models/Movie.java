package com.lundih.moviecatalogue.models;

public class Movie {
    private String movieId;
    private String name;
    private String description;

    public Movie(String movieId, String name, String description) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
    }

    // When java is unmarshalling an into an object it needs to have the empty constructor
    public Movie() { }

    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
