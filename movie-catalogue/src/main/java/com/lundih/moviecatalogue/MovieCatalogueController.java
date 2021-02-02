package com.lundih.moviecatalogue;

import com.lundih.moviecatalogue.models.Movie;
import com.lundih.moviecatalogue.models.MovieCatalogueItem;
import com.lundih.moviecatalogue.models.RatingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/catalogue")
public class MovieCatalogueController {

    private final RestTemplate restTemplate;

    @Autowired
    public MovieCatalogueController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{userId}")
    public List<MovieCatalogueItem> getCatalogue(@PathVariable("userId")  String userId) {

        // Make call to url and receive response as a string
        // Provide a class with the same properties as the response json and the rest template is gonna create an
        // instance of the class and populate the properties and return the object

        // Get movies rated by user. The movie Ids are needed to get the movie details
        RatingItem[] ratings = restTemplate.getForObject("http://rating-service/api/v1/ratings/" + userId, RatingItem[].class);

        List<MovieCatalogueItem> catalogue = new ArrayList<>();

        if (ratings != null) {
            for (RatingItem rating : ratings) {
                // Get movie details of those movie ids
                Movie movie =
                        restTemplate.getForObject("http://movie-service/api/v1/movies/" + rating.getMovieId(), Movie.class);
                catalogue.add(
                        // Combine movie details and ratings
                        new MovieCatalogueItem(rating.getMovieId(),
                                movie.getName(),
                                movie.getDescription(),
                                rating.getRating())
                );
            }
        }

        return catalogue;
    }
}
