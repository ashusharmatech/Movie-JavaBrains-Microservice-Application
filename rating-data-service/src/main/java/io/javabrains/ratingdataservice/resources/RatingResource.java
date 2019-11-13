package io.javabrains.ratingdataservice.resources;

import io.javabrains.ratingdataservice.models.Rating;
import io.javabrains.ratingdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingResource {


    @RequestMapping("/{movieId}")
    public Rating getMovieInfo(@PathVariable("movieId")String movieId){
        return new Rating(movieId,getRandom(5));
    }

    public static int getRandom(int max){
        return (int) (Math.random()*max);
    }



    @RequestMapping("/user/{userId}")
    public UserRating getRatings(@PathVariable("userId")String userId){
        //Get all rated movie ids
        List<Rating> ratings = Arrays.asList(
                new Rating("tt9248934",1),
                new Rating("tt7059844",4)
        );

        UserRating userRating = new UserRating();
        userRating.setRatings(ratings);

        return userRating;
    }


}
