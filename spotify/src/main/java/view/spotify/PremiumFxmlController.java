package view.spotify;

import controller.user.ListenerControl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.PremiumSubscriptionPackages;
import model.exception.LowCreditException;

import java.net.URL;
import java.util.ResourceBundle;

public class PremiumFxmlController implements Initializable {



    @FXML
    private Label finalLabel;

    @FXML
    private Button five;

    @FXML
    private Button fourteen;

    @FXML
    private Button nineC;

    @FXML
    private AnchorPane playBar;

    @FXML
    private AnchorPane sideBar;

    @FXML
    void fiveC(MouseEvent event) throws LowCreditException {
        try {
            ListenerControl.getListenerControlInstance().getPremium(PremiumSubscriptionPackages.oneMonth);
            finalLabel.setText("welcome to a whole new world!");
            five.setText("selected");
        } catch (LowCreditException e) {
            finalLabel.setText("your credit is low");
            throw new RuntimeException(e);
        }

    }

    @FXML
    void fourteenC(MouseEvent event)  {
        try {
            ListenerControl.getListenerControlInstance().getPremium(PremiumSubscriptionPackages.sixMonths);
            finalLabel.setText("welcome to a whole new world!");
            fourteen.setText("selected");
        } catch (LowCreditException e) {
            finalLabel.setText("your credit is low");
            throw new RuntimeException(e);
        }


    }

    @FXML
    void nineC(MouseEvent event) throws LowCreditException {
        try {
            ListenerControl.getListenerControlInstance().getPremium(PremiumSubscriptionPackages.twoMonths);
            finalLabel.setText("welcome to a whole new world!");
            nineC.setText("selected");
        } catch (LowCreditException e) {
            finalLabel.setText("your credit is low");
            throw new RuntimeException(e);
        }


    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        sideBar.getChildren().add(PageController.sideBar);
        playBar.getChildren().add(HelloApplication.PlayBar);

    }

}
