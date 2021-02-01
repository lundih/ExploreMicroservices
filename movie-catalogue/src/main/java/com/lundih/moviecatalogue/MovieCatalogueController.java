package com.lundih.moviecatalogue;

import com.lundih.moviecatalogue.models.Movie;
import com.lundih.moviecatalogue.models.MovieCatalogueItem;
import com.lundih.moviecatalogue.models.RatingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/catalogue")
public class MovieCatalogueController {
    WebClient.Builder webclientBuilder;

    @Autowired
    public MovieCatalogueController(@Qualifier("WebClientBuilder") WebClient.Builder webclientBuilder) {
        this.webclientBuilder = webclientBuilder;
    }

    @GetMapping("/{userId}")
    public List<MovieCatalogueItem> getCatalogue(@PathVariable("userId")  String userId) {

        // Make call to url and receive response as a string
        // Provide a class with the same properties as the response json and the webclient is gonna create an
        // instance of the class and populate the properties and return the object

        // Get movies rated by user. The movie Ids are needed to get the movie details
        RatingItem[] ratings = webclientBuilder.build()
                .get() // Because this is a get request
                .uri("http://localhost:8082/api/v1/ratings/" + userId)
                .retrieve()
                .bodyToMono(RatingItem[].class)
                .block(); // Block execution until results are back

        List<MovieCatalogueItem> catalogue = new ArrayList<>();

        if (ratings != null) {
            for (RatingItem rating : ratings) {
                // Get movie details of those movie ids
                Movie movie = webclientBuilder.build()
                        .get()
                        .uri("http://localhost:8081/api/v1/movies/" + rating.getMovieId())
                        .retrieve()
                        .bodyToMono(Movie.class)
                        .block();

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
