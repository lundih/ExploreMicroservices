package com.lundih.moviecatalogue.models;

public class MovieCatalogueItem {
    private final String movieId;
    private final String name;
    private final String description;
    private final int rating;

    public MovieCatalogueItem(String movieId, String name, String description, int rating) {
        this.movieId = movieId;
        this.name = name;
        this.description = description;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRating() {
        return rating;
    }
}
