/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.game;

import domain.interactions.InteractionsRequest;
import domain.resources.ResourcesReader;
import domain.systems.SystemsReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author Nikos
 */
public class GameViewController implements Initializable, ResourcesReader, SystemsReader, InteractionsRequest {

    /**
     * Progress bar visualizing life variable.
     */
    @FXML
    private ProgressBar progressBarLife;

    /**
     * Progress bar visualizing oxygen variable.
     */
    @FXML
    private ProgressBar progressBarOxygen;

    @FXML
    private Label waveNumberValue;

    @FXML
    private Label waveTimeLabel;
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

    private static ProgressBar life;
    private static ProgressBar oxygen;
    
    private ArrayList<String> consoleText = new ArrayList<>();
    private static GameViewController controller = new GameViewController();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller.progressBarLife = progressBarLife;
        controller.progressBarOxygen = progressBarOxygen;
        controller.waveTimeLabel = waveTimeLabel;
        controller.waveNumberValue = waveNumberValue;
    }

    public static void update() {
            controller.progressBarLife.setProgress((double)controller.readLife() / 100);
            controller.progressBarOxygen.setProgress((double)controller.readOxygen() / 100);
            controller.waveTimeLabel.setText(Long.toString(controller.readWaveTime()));
            controller.waveNumberValue.setText(Integer.toString(controller.readWaveNumber()));
    }

    /**
     * When enter is pressed, handle inputText and outputText.
     *
     * @param event
     */
    @FXML
    private void enterPressedHandler(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            if (inputText.getText().equals("")) {
                return;
            }

            consoleText.add(inputText.getText());
            outputText.setText(textToString(consoleText));
            outputText.setScrollTop(10000);

            String commandOutput = this.requestRunCommand(inputText.getText());
            infoText.setText(commandOutput);
            infoText.setScrollTop(10000);
            infoText.positionCaret(commandOutput.length());

            inputText.setText("");
        }
    }

    /**
     * Method that takes text as input and returns it as String.
     *
     * @param consoleText
     * @return
     */
    private String textToString(ArrayList<String> consoleText) {
        String consoleString = "";

        for (String string : consoleText) {
            consoleString += "> " + string + "\n";
        }
        return consoleString;
    }
}
