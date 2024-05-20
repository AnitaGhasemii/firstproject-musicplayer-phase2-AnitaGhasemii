package view.spotify;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import model.Genre;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class genreFxmlController implements Initializable {
    ArrayList<Genre> genre;
    @FXML
    private AnchorPane ap11;

    @FXML
    private AnchorPane apInterview;

    @FXML
    private AnchorPane apSociety;

    @FXML
    private AnchorPane apHistory;

    @FXML
    private AnchorPane aphipHop;

    @FXML
    private AnchorPane apjazz;

    @FXML
    private Button applyButton;

    @FXML
    private AnchorPane appop;

    @FXML
    private AnchorPane aprock;

    @FXML
    private AnchorPane aptrueCrim;

    @FXML
    private Button backButton;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private GridPane mainGride;

    @FXML
    private Label titleLable;

    @FXML
    void applyClicked(MouseEvent event) throws IOException {
PageController.afterLogin();
    }

    @FXML
    void backClicked(MouseEvent event) throws IOException {
        PageController.signUpPage();

    }

    @FXML
    void countryC(MouseEvent event) {
        if(genre.contains(Genre.COUNTRY)) {
            ap11.setStyle("-body-background-color: #111111");
            genre.remove(Genre.COUNTRY);
        }else if(genre.size()<4){
            ap11.setStyle("-fx-background-color: #288028");
            genre.add(Genre.COUNTRY);
        }
    }



    @FXML
    void historyC(MouseEvent event) {
        if(genre.contains(Genre.History)) {
            apHistory.setStyle("-body-background-color: #111111");
            genre.remove(Genre.History);
        }else if(genre.size()<4){
            apHistory.setStyle("-fx-background-color: #288028");
            genre.add(Genre.History);
        }

    }

    @FXML
    void interC(MouseEvent event) {
        if(genre.contains(Genre.Interview)) {
            apInterview.setStyle("-body-background-color: #111111");
            genre.remove(Genre.Interview);
        }else if(genre.size()<4){
            apInterview.setStyle("-fx-background-color: #288028");
            genre.add(Genre.JAZZ);
        }
    }

    @FXML
    void jazzC(MouseEvent event) {
        if(genre.contains(Genre.JAZZ)) {
            apjazz.setStyle("-body-background-color: #111111");
            genre.remove(Genre.JAZZ);
        }else if(genre.size()<4){
            apjazz.setStyle("-fx-background-color: #288028");
            genre.add(Genre.JAZZ);
        }
    }

    @FXML
    void popC(MouseEvent event) {
        if(genre.contains(Genre.POP)) {
            appop.setStyle("-body-background-color: #111111");
            genre.remove(Genre.POP);
        }else if(genre.size()<4){
            appop.setStyle("-fx-background-color: #288028");
            genre.add(Genre.POP);
        }
    }

    @FXML
    void rockC(MouseEvent event) {
        if(genre.contains(Genre.ROCK)) {
            aprock.setStyle("-body-background-color: #111111");
            genre.remove(Genre.ROCK);
        }else if(genre.size()<4){
            aprock.setStyle("-fx-background-color: #288028");
            genre.add(Genre.ROCK);
        }

    }

    @FXML
    void societyC(MouseEvent event) {
        if(genre.contains(Genre.Society)) {
            apSociety.setStyle("-body-background-color: #111111");
            genre.remove(Genre.Society);
        }else if(genre.size()<4){
            apSociety.setStyle("-fx-background-color: #288028");
            genre.add(Genre.Society);
        }

    }

    @FXML
    void trueC(MouseEvent event) {
        if(genre.contains(Genre.TRUECRIME)) {
            aptrueCrim.setStyle("-body-background-color: #111111");
            genre.remove(Genre.TRUECRIME);
        }else if(genre.size()<4){
            aptrueCrim.setStyle("-fx-background-color: #288028");
            genre.add(Genre.TRUECRIME);
        }

    }

    @FXML
    void hipC(MouseEvent event) {
        if(genre.contains(Genre.HIPHOP)) {
            aphipHop.setStyle("-body-background-color: #111111");
            genre.remove(Genre.HIPHOP);
        }else if(genre.size()<4){
            aphipHop.setStyle("-fx-background-color: #288028");
            genre.add(Genre.HIPHOP);
        }

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genre = new ArrayList<>();
    }
}
