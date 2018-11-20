/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.game;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nikos
 */
public class GameViewController implements Initializable {
    
    /**
     * Progress bar visualising life variable.
     */
    @FXML
    private ProgressBar progressBarLife;
    
    /**
     * Number visualising the number of current wave.
     */
    @FXML
    private TextArea waveNumber;
    
    /**
     * Number visualising the remaining time for the current wave.
     */
    @FXML
    private TextArea timeNumber;
    
    /**
     * Progress bar visualising oxygen variable.
     */
    @FXML
    private ProgressBar progressBarOxygen;
    
    /**
     * Canvas, where the games maps will be drawn.
     */
    @FXML
    private Canvas canvasMap;
    
    /**
     * Text the user inputs, will be shown here.
     */
    @FXML
    private TextArea outputText;
    
    /**
     * Text interface, where user can send inputs via text.
     */
    @FXML
    private TextField inputText;
    
    /**
     * Text area, where relevant information will be shown.
     */
    @FXML
    private TextArea infoText;

    /**
     * Initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
