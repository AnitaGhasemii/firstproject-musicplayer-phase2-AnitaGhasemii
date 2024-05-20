package view.spotify;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.DataBase;
import model.audio.Audio;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AllAudioFxmlController implements Initializable {

    @FXML
    private AnchorPane ScrollPane;

    @FXML
    private Label artistName;

    @FXML
    private VBox audiosVBox;

    @FXML
    private AnchorPane playBar;

    @FXML
    private Button searchButt;

    @FXML
    private PasswordField searchField;

    @FXML
    private AnchorPane sideBar;

    @FXML
    void searchButtC(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sideBar.getChildren().add(PageController.sideBar);
        playBar.getChildren().add(HelloApplication.PlayBar);
        for(Audio  ad :  DataBase.getDataBase().getAudios()){
            Button bt = new Button(ad.getName());
            audiosVBox.getChildren().add(bt);
            bt.setOnMouseClicked(E->{
                playMusicFxmlController.audio = ad;
                try {
                    PageController.playPage();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });




        }
    }
}
