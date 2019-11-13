package io.javabrains.movieinfoservice.resources;

import io.javabrains.movieinfoservice.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Autowired
    RestTemplate restTemplate;

    Map<String, Movie> movieMap  = new HashMap<String, Movie>() {{
        put("1", new Movie("1","War","Yash Raj Films"));
        put("2", new Movie("2","Kabir Singh","T-Series"));
        put("3", new Movie("3","Uri: The Surgical Strike","RSVP Movies"));
        put("4", new Movie("4","Bharat","Salman Khan Films"));
        put("5", new Movie("5","Mission Mangal","Cape of Good Films"));
        put("6", new Movie("6","Housefull 4","Fox Star Studios"));
    }};

    @RequestMapping("{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId")String movieId){
        return movieMap.get(movieId) ;
    }


    @RequestMapping("/omdb/{imdbId}")
    public Movie getMovieFromOmdbApi(@PathVariable("imdbId") String imbdId){

        String url = "http://www.omdbapi.com/?apikey=ce68d15e&i=";
        return restTemplate.getForObject(url+imbdId , Movie.class);


    }

}
