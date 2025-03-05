package com.example.gui12moviereviews;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class StarterController {
    public Button blackButton;
    public Button kingButton;
    public Button killerButton;
    public Button mermaidButton;
    public Button doctorButton;

    String getJSONfromURL(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        InputStreamReader inStream = new InputStreamReader(connection.getInputStream());
        BufferedReader reader = new BufferedReader(inStream);
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return response.toString();
    }
    public MovieReviewData randomReview(String movieId) throws Exception{
        String jsonReview = this.getJSONfromURL("https://www.omdbapi.com/?i=" + movieId + "&apikey=dd909fa");
        System.out.println("Movie Review" + jsonReview);
        ObjectMapper objectMapper = new ObjectMapper();
        MovieReviewData review = objectMapper.readValue(jsonReview, MovieReviewData.class);
        System.out.println(review);
        return review;
    }

    public ArrayList<MovieReviewData> getManyReviews(String searchTerm) throws Exception {
        ArrayList<MovieReviewData> manyReviews = new ArrayList<>();

        for (int i = 1; i < 2; i = i + 1) {
            // get json array with many reviews
            String jsonReviews = this.getJSONfromURL("https://www.omdbapi.com/?s=" + searchTerm + "&apikey=dd909fa&type=movie&page=" + i);
            System.out.println("Movie Reviews" + jsonReviews);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode reviews = objectMapper.readTree(jsonReviews);
            JsonNode reviewsArray = reviews.get("Search");
            for (JsonNode eachReview : reviewsArray) {
                String imdbId = eachReview.get("imdbID").textValue();
                MovieReviewData newReview = randomReview(imdbId);
                manyReviews.add(newReview);
            }
        }

        System.out.println(manyReviews);
        return manyReviews;
    }
    public void blackNextView() throws Exception{
        getManyReviews("black");
        FXMLLoader fxmlLoader = new FXMLLoader(ReviewController.class.getResource("movie-review-view.fxml"));
        Scene gameScene = new Scene(fxmlLoader.load(), 600, 400);
        Stage mainStage = (Stage)blackButton.getScene().getWindow();
        mainStage.setScene(gameScene);
        mainStage.show();
    }

    public void doctorNextView() throws Exception{
        getManyReviews("doctor");
        FXMLLoader fxmlLoader = new FXMLLoader(ReviewController.class.getResource("movie-review-view.fxml"));
        Scene gameScene = new Scene(fxmlLoader.load(), 600, 400);
        Stage mainStage = (Stage)doctorButton.getScene().getWindow();
        mainStage.setScene(gameScene);
        mainStage.show();
    }

    public void mermaidNextView() throws Exception{
        getManyReviews("mermaid");
        FXMLLoader fxmlLoader = new FXMLLoader(ReviewController.class.getResource("movie-review-view.fxml"));
        Scene gameScene = new Scene(fxmlLoader.load(), 600, 400);
        Stage mainStage = (Stage)mermaidButton.getScene().getWindow();
        mainStage.setScene(gameScene);
        mainStage.show();
    }
    public void killerNextView() throws Exception{
        getManyReviews("killer");
        FXMLLoader fxmlLoader = new FXMLLoader(ReviewController.class.getResource("movie-review-view.fxml"));
        Scene gameScene = new Scene(fxmlLoader.load(), 600, 400);
        Stage mainStage = (Stage)killerButton.getScene().getWindow();
        mainStage.setScene(gameScene);
        mainStage.show();
    }

    public void kingNextView() throws Exception{
        getManyReviews("king");
        FXMLLoader fxmlLoader = new FXMLLoader(ReviewController.class.getResource("movie-review-view.fxml"));
        Scene gameScene = new Scene(fxmlLoader.load(), 600, 400);
        Stage mainStage = (Stage)kingButton.getScene().getWindow();
        mainStage.setScene(gameScene);
        mainStage.show();
    }

}
