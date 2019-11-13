package io.javabrains.moviecatalogservice.models;

public class Rating {
    private String movieId;
    private int rating;

    public Rating() {
    }
    public Rating(String movieId, int rating) {

        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public int getRating() {
        return rating;
    }


}
