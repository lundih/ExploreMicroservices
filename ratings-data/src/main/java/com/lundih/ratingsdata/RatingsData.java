package com.lundih.ratingsdata;

public class RatingsData {

    private final String movieId;
    private final Integer rating;

    public RatingsData(String movieId, Integer rating){
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public Integer getRating() {
        return rating;
    }
}
