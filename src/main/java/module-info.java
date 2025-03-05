module com.example.gui12moviereviews {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.gui12moviereviews to javafx.fxml;
    exports com.example.gui12moviereviews;
}