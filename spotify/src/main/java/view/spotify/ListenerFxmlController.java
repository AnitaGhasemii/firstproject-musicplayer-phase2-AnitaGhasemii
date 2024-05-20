package view.spotify;

import controller.user.ListenerControl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Playlist;
import model.exception.FreeAccountLimitException;
import model.userAcc.Listener.Listener;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListenerFxmlController implements Initializable {

    @FXML
    private Button addPlayList;

    @FXML
    private Label emailLable;

    @FXML
    private Label nameLable;

    @FXML
    private Label passwordLable;

    @FXML
    private Label phoneLable;

    @FXML
    private VBox playlist;

    @FXML
    private TextField playlistNameF;

    @FXML
    private Button searchButt;

    @FXML
    private PasswordField searchField;

    @FXML
    private Label usernameLable;

    @FXML
    private AnchorPane sideBar;

    @FXML
    private AnchorPane playBar;


    @FXML
    void addPlaylistC(MouseEvent event) {


        if(!ListenerControl.getListenerControlInstance().playListAvailable(playlistNameF.getText())){
        try {
            ListenerControl.getListenerControlInstance().newPlaylist(playlistNameF.getText());
            playlist.getChildren().clear();
            for(Playlist PL : Listener.getListener().getPlaylists()) {

                playlist.getChildren().add(new Button(PL.getPlaylistName()));

            }
        } catch (FreeAccountLimitException e) {
            Alert a = new Alert(Alert.AlertType.ERROR,e.getMessage());
            a.show();
        }}else{
            Alert a = new Alert(Alert.AlertType.ERROR,"playList name available");
            a.show();
        }


    }




    @FXML
    void premiumC(MouseEvent event) throws IOException {
        PageController.premiumPage();

    }

    @FXML
    void searchButtC(MouseEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sideBar.getChildren().add(PageController.sideBar);
        playBar.getChildren().add(HelloApplication.PlayBar);
        nameLable.setText(Listener.getListener().getNameAndFamily());
        usernameLable.setText(Listener.getListener().getUserName());
        passwordLable.setText(Listener.getListener().getPassword());
        phoneLable.setText(Listener.getListener().getPhoneNumber());
        emailLable.setText(Listener.getListener().getEmail());
        for(Playlist PL : Listener.getListener().getPlaylists()) {

            playlist.getChildren().add(new Button(PL.getPlaylistName()));

        }
    }
}
