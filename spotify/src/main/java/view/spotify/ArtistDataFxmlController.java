package view.spotify;

import controller.user.ListenerControl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.userAcc.Artist.Artist;
import model.userAcc.Listener.Listener;
import model.userAcc.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ArtistDataFxmlController implements Initializable {
    @FXML
    private Label report;

    @FXML
    private Button reportButt;

    @FXML
    private TextArea reportText;


    @FXML
    private AnchorPane ScrollPane;

    @FXML
    private Label artistName;

    @FXML
    private VBox audiosVBox;

    @FXML
    private Button followButt;

    @FXML
    private Label followersNumber;

    @FXML
    private AnchorPane playBar;

    @FXML
    private Button searchButt;

    @FXML
    private PasswordField searchField;

    @FXML
    private AnchorPane sideBar;

    @FXML
    void FollowButtC(MouseEvent event) {
        if (ListenerControl.getListenerControlInstance().followArtist(selectedArtist).equals("followed")) {
            followButt.setText("followed");
            followersNumber.setText("FOLLOWERS    " + selectedArtist.getFollowers().size());
        }


    }

    @FXML
    void searchButtC(MouseEvent event) {

    }


    private static Artist selectedArtist;

    public static void setSelectedArtist(Artist selectedArtist) {
        ArtistDataFxmlController.selectedArtist = selectedArtist;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sideBar.getChildren().add(PageController.sideBar);
        playBar.getChildren().add(HelloApplication.PlayBar);
        artistName.setText(selectedArtist.getNameAndFamily());
        followersNumber.setText("FOLLOWERS    " + selectedArtist.getFollowers().size());

    }

    @FXML
    void reportC(MouseEvent event) {
        ListenerControl.getListenerControlInstance().reportArtist
                (reportText.getText(), selectedArtist);
        reportButt.setText("reported");
    }
}
