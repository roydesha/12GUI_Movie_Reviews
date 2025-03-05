package com.example.gui12moviereviews;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rating {
    @JsonProperty("Source")
    public String ratingSource;

    @JsonProperty("Value")
    public String ratingValue;

    public String getRatingSource() {
        return ratingSource;
    }

    public void setRatingSource(String ratingSource) {
        this.ratingSource = ratingSource;
    }

    public String getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(String ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String toString () {
        return ratingSource + ", " + ratingValue;
    }

}
