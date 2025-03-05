package com.example.gui12moviereviews;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ReviewController {
    public TextArea questionBox;
    public TextArea plotArea;
    public RadioButton buttonOne;
    public RadioButton buttonTwo;
    public RadioButton buttonThree;
    public RadioButton buttonFour;
    public RadioButton buttonFive;
    public RadioButton buttonSix;
    public RadioButton buttonSeven;
    public RadioButton buttonEight;
    public RadioButton buttonNine;
    public RadioButton buttonTen;
    public Button nextButton;
    public Button againButton;
    public TextField movieTitleField;
   // public TextField plotField;
    public TextField awardField;
    public TextField revenueField;
    public TextField dateField;
    public ImageView posterView;
    public Label feedbackLabel;
    public Label scoreLabel;
    public ComboBox hintBox;
    MovieReviewData currentReviewToGuess;
    ToggleGroup ratingGroup = new ToggleGroup();
    int currentMovieNum;
    int score;


    public void displayMovie(MovieReviewData movie) {

        String posterURL = currentReviewToGuess.getPosterURL();
        Image posterImage = new Image(posterURL);
        posterView.setImage(posterImage);

        String movieTitle = currentReviewToGuess.getMovieTitle();
        movieTitleField.setText(movieTitle);

        questionBox.setText("What is the imdb rating of " + movieTitle + "?");

    }

    public void initialize () throws Exception {
        ArrayList<MovieReviewData> currentReviews = MovieReviewData.currentReviews;
        currentMovieNum = (int) (Math.random() * currentReviews.size());
        currentReviewToGuess = currentReviews.get(currentMovieNum);
        score = 0;
        scoreLabel.setText("Score:  " + score);

        displayMovie(currentReviewToGuess);

        buttonOne.setToggleGroup(ratingGroup);
        buttonTwo.setToggleGroup(ratingGroup);
        buttonThree.setToggleGroup(ratingGroup);
        buttonFour.setToggleGroup(ratingGroup);
        buttonFive.setToggleGroup(ratingGroup);
        buttonSix.setToggleGroup(ratingGroup);
        buttonSeven.setToggleGroup(ratingGroup);
        buttonEight.setToggleGroup(ratingGroup);
        buttonNine.setToggleGroup(ratingGroup);
        buttonTen.setToggleGroup(ratingGroup);

        plotArea.setVisible(false);
        awardField.setVisible(false);
        revenueField.setVisible(false);
        dateField.setVisible(false);
        againButton.setVisible(false);


        hintBox.setOnAction(actionEvent -> {
            Object choice  = hintBox.getValue();
            System.out.println(choice);
            if (choice.toString().equalsIgnoreCase("Plot")) {
                plotArea.setVisible(true);
                plotArea.setText(currentReviewToGuess.getMoviePlot());
                //change to a text area

            } else if (choice.toString().equalsIgnoreCase("Release Date")) {
                dateField.setVisible(true);
                dateField.setText(currentReviewToGuess.getMovieReleaseDate());


            } else if (choice.toString().equalsIgnoreCase("Awards")) {
                awardField.setText(currentReviewToGuess.getMovieAwards());
                awardField.setVisible(true);

            } else {
                revenueField.setText(currentReviewToGuess.getMovieBoxOffice());
                revenueField.setVisible(true);
            }

        });

        hintBox.getItems().add("Plot");
        hintBox.getItems().add("Release Date");
        hintBox.getItems().add("Awards");
        hintBox.getItems().add("Box Office Revenue");


    }

    public void radioRating () {
        RadioButton selectedButton = (RadioButton) ratingGroup.getSelectedToggle();
        int rating = 0;
        if (selectedButton == buttonOne) {
            rating = 1;
        } else if (selectedButton == buttonTwo) {
            rating = 2;
        } else if (selectedButton == buttonThree) {
            rating = 3;
        } else if (selectedButton == buttonFour) {
            rating = 4;
        } else if (selectedButton == buttonFive) {
            rating = 5;
        } else if (selectedButton == buttonSix) {
            rating = 6;
        } else if (selectedButton == buttonSeven) {
            rating = 7;
        } else if (selectedButton == buttonEight) {
            rating = 8;
        } else if (selectedButton == buttonNine) {
            rating = 9;
        } else if (selectedButton == buttonTen) {
            rating = 10;
        }

            int currentRating = Float.valueOf(currentReviewToGuess.movieImdbRating).intValue();
            System.out.println(currentRating);
            if (rating == currentRating) {
                feedbackLabel.setVisible(true);
                feedbackLabel.setText("You Got It!");
                int newScore = score + 100;
                scoreLabel.setText("Score: " + newScore);
            } else {
                feedbackLabel.setVisible(true);
                feedbackLabel.setText("Incorrect, right Answer is " + currentRating);
                nextButton.setVisible(false);
                againButton.setVisible(true);
            }
        }

        public void newQuestion() throws Exception {
            RadioButton selectedButton = (RadioButton) ratingGroup.getSelectedToggle();
            selectedButton.setSelected(false);
            feedbackLabel.setVisible(false);
            plotArea.setVisible(false);
            revenueField.setVisible(false);
            dateField.setVisible(false);
            awardField.setVisible(false);

            MovieReviewData.currentReviews.remove(currentReviewToGuess);
            currentMovieNum = (int) (Math.random() * MovieReviewData.currentReviews.size());
            currentReviewToGuess = MovieReviewData.currentReviews.get(currentMovieNum);

            displayMovie(currentReviewToGuess);


        }

        public void playAgainView() throws Exception {
            MovieReviewData.currentReviews.clear();
            FXMLLoader fxmlLoader = new FXMLLoader(ReviewController.class.getResource("ReviewGameStarterView.fxml"));
            Scene gameScene = new Scene(fxmlLoader.load(), 600, 400);
            Stage mainStage = (Stage)againButton.getScene().getWindow();
            mainStage.setScene(gameScene);
            mainStage.show();
        }

        }






