package view.spotify;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.userAcc.User;

import java.io.IOException;

public class PageController {
    public static Stage MainStage;
    public static AnchorPane sideBar;

        public static AnchorPane sidBar() throws IOException {

            return sideBar;
        }



    public static void MainPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        MainStage.setTitle("Hello!");
        MainStage.setScene(scene);
        MainStage.show();
    }
    public static void LoginPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("logIn-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        MainStage.setTitle("Hello!");
        MainStage.setScene(scene);

    }
    public static void signUpPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("signUp-fxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        MainStage.setTitle("Hello!");
        MainStage.setScene(scene);

    }
    public static void playPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("playMusic-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        MainStage.setTitle("Hello!");
        MainStage.setScene(scene);

    }
    public static void genrePage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("genre-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        MainStage.setTitle("Hello!");
        MainStage.setScene(scene);

    }
    public static void listenerPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("listener-fxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        MainStage.setTitle("Hello!");
        MainStage.setScene(scene);

    }
    public static void premiumPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("premium-fxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        MainStage.setTitle("Hello!");
        MainStage.setScene(scene);

    }
    public static void showPlayListMusicPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("playlist-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        MainStage.setTitle("Hello!");
        MainStage.setScene(scene);

    }
    public static void allArtistPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("artist-fxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        MainStage.setTitle("Hello!");
        MainStage.setScene(scene);

    }
    public static void allAudioPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("audio-fxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        MainStage.setTitle("Hello!");
        MainStage.setScene(scene);

    }
    public static void artistInfoPage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("artistData-fxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        MainStage.setTitle("Hello!");
        MainStage.setScene(scene);

    }
    public static void afterLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("afterLogin-fxml.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        MainStage.setTitle("Hello!");
        MainStage.setScene(scene);

    }





}
