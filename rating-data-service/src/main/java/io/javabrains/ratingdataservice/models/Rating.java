package io.javabrains.ratingdataservice.models;

public class Rating {
    private final String movieId;
    private final int rating;

    public String getMovieId() {
        return movieId;
    }

    public int getRating() {
        return rating;
    }

    public Rating(String movieId, int rating) {

        this.movieId = movieId;
        this.rating = rating;
    }
}
