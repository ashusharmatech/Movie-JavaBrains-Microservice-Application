package io.javabrains.moviecatalogservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

    public String imdbID;
    public String title;
    public String year;
    public String plot;
    public String language;
    public String seriesID;
    public String director;

    public Movie() {

    }

    public Movie(String imdbID, String title, String director) {
        this.imdbID = imdbID;
        this.title = title;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    @JsonProperty("Year")
    public void setYear(String year) {
        this.year = year;
    }

    public String getPlot() {
        return plot;
    }

    @JsonProperty("Plot")
    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    @JsonProperty("Language")
    public void setLanguage(String language) {
        this.language = language;
    }

    public String getImdbID() {
        return imdbID;
    }

    @JsonProperty("imdbID")
    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getSeriesID() {
        return seriesID;
    }

    @JsonProperty("seriesID")
    public void setSeriesID(String seriesID) {
        this.seriesID = seriesID;
    }

    public String getDirector() {
        return director;
    }
    @JsonProperty("Director")
    public void setDirector(String director) {
        this.director = director;
    }
}