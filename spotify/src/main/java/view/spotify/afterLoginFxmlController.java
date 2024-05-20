package view.spotify;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class afterLoginFxmlController implements Initializable {


    @FXML
    private Button accshow;


    @FXML
    private AnchorPane playBar;

    @FXML
    private Button searchButt;

    @FXML
    private TextField searchField;
    @FXML
    private AnchorPane sideBar;

    @FXML
    void artistsButtC(MouseEvent event) throws IOException {
        PageController.allArtistPage();

    }

    @FXML
    void audiosButtC(MouseEvent event) throws IOException {
        PageController.allAudioPage();

    }



    @FXML
    void libraryButtC(MouseEvent event) throws IOException {
        PageController.afterLogin();

    }

    @FXML
    void searchButtC(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sideBar.getChildren().add(PageController.sideBar);
        playBar.getChildren().add(HelloApplication.PlayBar);
    }
    @FXML
    void accshowC(MouseEvent event) throws IOException {
PageController.listenerPage();
    }
}
