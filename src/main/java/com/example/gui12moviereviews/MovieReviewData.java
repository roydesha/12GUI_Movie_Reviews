package com.example.gui12moviereviews;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(value = { "Year","Rated", "Runtime","Genre", "Director", "Writer", "Actors", "Language", "Country", "Type", "DVD", "Production", "Website", "Response", "imdbVotes" })
public class MovieReviewData {

    @JsonProperty("Title")
    String movieTitle;

    @JsonProperty("Plot")
    String moviePlot;

    @JsonProperty("Ratings")
    ArrayList<Rating> movieRating;

    @JsonProperty("Metascore")
    String movieMetaScore;

    @JsonProperty("imdbRating")
    String movieImdbRating;

    @JsonProperty("imdbID")
    String movieImdbID;

    @JsonProperty("Poster")
    String posterURL;

    @JsonProperty("Awards")
    String movieAwards;

    @JsonProperty("BoxOffice")
    String movieBoxOffice;

    @JsonProperty("Released")
    String movieReleaseDate;

    static ArrayList<MovieReviewData> currentReviews = new ArrayList<>();


    public MovieReviewData() {
        currentReviews.add(this);
    }

    public MovieReviewData(String movieTitle, String moviePlot, ArrayList<Rating> movieRating, String movieMetaScore, String movieImdbRating, String movieImdbID) {
        this.movieTitle = movieTitle;
        this.moviePlot = moviePlot;
        this.movieRating = movieRating;
        this.movieMetaScore = movieMetaScore;
        this.movieImdbRating = movieImdbRating;
        this.movieImdbID = movieImdbID;
        currentReviews.add(this);
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMoviePlot() {
        return moviePlot;
    }

    public void setMoviePlot(String moviePlot) {
        this.moviePlot = moviePlot;
    }

    public ArrayList<Rating> getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(ArrayList<Rating> movieRating) {
        this.movieRating = movieRating;
    }

    public String getMovieMetaScore() {
        return movieMetaScore;
    }

    public void setMovieMetaScore(String movieMetaScore) {
        this.movieMetaScore = movieMetaScore;
    }

    public String getMovieImdbRating() {
        return movieImdbRating;
    }

    public void setMovieImdbRating(String movieImdbRating) {
        this.movieImdbRating = movieImdbRating;
    }

    public String getMovieImdbID() {
        return movieImdbID;
    }

    public void setMovieImdbID(String movieImdbID) {
        this.movieImdbID = movieImdbID;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public String getMovieAwards() {
        return movieAwards;
    }

    public void setMovieAwards(String movieAwards) {
        this.movieAwards = movieAwards;
    }

    public String getMovieBoxOffice() {
        return movieBoxOffice;
    }

    public void setMovieBoxOffice(String movieBoxOffice) {
        this.movieBoxOffice = movieBoxOffice;
    }

    public String getMovieReleaseDate() {
        return movieReleaseDate;
    }

    public void setMovieReleaseDate(String movieReleaseDate) {
        this.movieReleaseDate = movieReleaseDate;
    }

    public String toString() {
        return "This is a MovieReviewData for " + movieTitle + " rated " + movieMetaScore + " on MetaScore" + ", " + movieImdbRating + " on Imdb," +  movieRating ;

    }

}

