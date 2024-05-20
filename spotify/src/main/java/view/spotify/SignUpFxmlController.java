package view.spotify;

import controller.user.SignUp;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import model.exception.FailedLogInException.UserNotFoundException;
import model.exception.InvalidFormatException;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpFxmlController {

    @FXML
    private Button backButton;

    @FXML
    private DatePicker birthdayPick;

    @FXML
    private TextField emailField;

    @FXML
    private RadioButton listenerRadioButt;

    @FXML
    private TextField nameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private RadioButton podcasterRadioButt;

    @FXML
    private ToggleGroup q;

    @FXML
    private RadioButton singerRadioButt;

    @FXML
    private Button submitButton;

    @FXML
    private TextField usernameField;

    @FXML
    void backButtonC(MouseEvent event) throws IOException {
        PageController.MainPage();

    }


    @FXML
    void submitButtonC(MouseEvent event) {


        if (listenerRadioButt.isSelected()) {
            try {
                SignUp.signUp().signUpListener(usernameField.getText(), passwordField.getText(), nameField.getText(), emailField.getText(), phoneNumberField.getText(), birthdayPick.getValue());
                PageController.genrePage();
            } catch (InvalidFormatException | IOException | UserNotFoundException e) {
                Alert a = new Alert(Alert.AlertType.ERROR,
                        e.getMessage(), ButtonType.APPLY);
                a.show();
            }

        } else if (podcasterRadioButt.isSelected()) {
            try {
                SignUp.signUp().signUpPodcaster(usernameField.getText(), passwordField.getText(), nameField.getText(), emailField.getText(), phoneNumberField.getText(), birthdayPick.getValue(), "");
            } catch (InvalidFormatException | UserNotFoundException e) {
                Alert a = new Alert(Alert.AlertType.ERROR,
                        e.getMessage(), ButtonType.APPLY);
                a.show();
            }


        } else if (singerRadioButt.isSelected()) {
            try {
                SignUp.signUp().signUpSinger(usernameField.getText(), passwordField.getText(), nameField.getText(), emailField.getText(), phoneNumberField.getText(), birthdayPick.getValue(), "");
            } catch (InvalidFormatException | UserNotFoundException e) {
                Alert a = new Alert(Alert.AlertType.ERROR,
                        e.getMessage(), ButtonType.APPLY);
                a.show();
            }


        }
    }


}


