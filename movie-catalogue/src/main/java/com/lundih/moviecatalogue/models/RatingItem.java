package com.lundih.moviecatalogue.models;

public class RatingItem {
    private String movieId;
    private Integer rating;

    public RatingItem(String movieId, Integer rating){
        this.movieId = movieId;
        this.rating = rating;
    }

    public RatingItem() {}

    public String getMovieId() {
        return movieId;
    }

    public Integer getRating() {
        return rating;
    }
}
