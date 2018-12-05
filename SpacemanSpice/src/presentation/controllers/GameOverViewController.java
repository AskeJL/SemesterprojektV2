/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author askel
 */
public class GameOverViewController extends ViewController implements Initializable {

    @FXML
    private Label gameOverField;
    @FXML
    private TextField scoreField;
    @FXML
    private Button menuButton;
    @FXML
    private Button quitButton;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void menuButtonHandler(ActionEvent event) throws IOException {
        
    }

    @FXML
    private void quitButtonHandler(ActionEvent event) {
    }

    @Override
    public void update() {
        // Nothing to update
    }

    @FXML
    private void initialize(ActionEvent event) {
    }
}
