/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.menu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author askel
 */
public class MenuViewController implements Initializable {

    @FXML
    private Button highscoreButton;
    @FXML
    private Button quitButton;
    @FXML
    private Button playButton;
    @FXML
    private Label spacemanspiceLabel;
    @FXML
    private Button settingsButton;
    @FXML
    private Label createdByLabel;
    @FXML
    private Label nameLabel1;
    @FXML
    private Label nameLabel2;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void onHighScore(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("highscoreView.fxml"));
        Stage stage = new Stage();
         stage.setScene(new Scene(pane));
         stage.show();
    }

    @FXML
    private void onQuitHandler(ActionEvent event) {
    }

    @FXML
    private void onPlayHandler(ActionEvent event) {
    }

    @FXML
    private void onSettingsHandler(ActionEvent event) {
    }
    
}
