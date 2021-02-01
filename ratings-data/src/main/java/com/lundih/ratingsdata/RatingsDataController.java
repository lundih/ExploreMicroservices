package com.lundih.ratingsdata;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/ratings")
public class RatingsDataController {

    @GetMapping("/{userId}")
    public List<RatingsData> getRating(@PathVariable("userId") String userId) {
        // Ideally the userId would be used to fetch the ist of  movies they've rated
        return  List.of(
                new RatingsData("abcd", 1),
                new RatingsData("efgh", 2),
                new RatingsData("ijkl", 3)
        );
    }
}
