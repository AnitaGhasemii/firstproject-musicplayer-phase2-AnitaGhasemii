package view.spotify;

import controller.user.ListenerControl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.userAcc.Artist.Artist;
import model.userAcc.User;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AllArtistFxmlController implements Initializable {

//    @FXML
//    private AnchorPane artistsAnchorPain;

    @FXML
    private VBox artistsVBox;
    @FXML
    private AnchorPane sideBar;

    @FXML
    private AnchorPane playBar;

    @FXML
    private Button searchButt;

    @FXML
    private TextField searchField;



    @FXML
    void searchButtC(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sideBar.getChildren().add(PageController.sideBar);
        playBar.getChildren().add(HelloApplication.PlayBar);

        ArrayList<User> artists =
                ListenerControl.getListenerControlInstance().showArtists();

        for (User artist : artists){


            Button button = new Button(artist.getNameAndFamily());
            button.setOnAction(e -> {

                try {
                    Artist ar = (Artist) artist;

                    ArtistDataFxmlController.setSelectedArtist(ar);

                    PageController.artistInfoPage();

                } catch (IOException ignored){}
            });

            artistsVBox.getChildren().add(button);
        }
    }
}
