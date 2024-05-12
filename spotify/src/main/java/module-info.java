module view.spotify {
    requires javafx.controls;
    requires javafx.fxml;


    opens view.spotify to javafx.fxml;
    exports view.spotify;
}