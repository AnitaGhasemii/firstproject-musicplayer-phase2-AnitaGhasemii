package view.spotify;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class SideBarController {

    @FXML
    private Button artistsButt;

    @FXML
    private Button audiosButt;

    @FXML
    private Button backButt;

    @FXML
    private Button homeButt;

    @FXML
    private Button libraryButt;

    @FXML
    void artistsButtC(MouseEvent event) throws IOException {
        PageController.allArtistPage();

    }

    @FXML
    void audiosButtC(MouseEvent event) throws IOException {
        PageController.allAudioPage();

    }

    @FXML
    void backButtC(MouseEvent event) {


    }

    @FXML
    void homeButtC(MouseEvent event) throws IOException {
        PageController.afterLogin();

    }

    @FXML
    void libraryButtC(MouseEvent event) throws IOException {
        PageController.listenerPage();

    }
}