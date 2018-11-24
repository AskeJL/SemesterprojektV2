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
    
    private static String lastOutput = "";
    
    private ArrayList<String> consoleText = new ArrayList<>();
    private static GameViewController interfaces = new GameViewController();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        interfaces.progressBarLife = progressBarLife;
        interfaces.progressBarOxygen = progressBarOxygen;
        interfaces.waveTimeLabel = waveTimeLabel;
        interfaces.waveNumberValue = waveNumberValue;
        interfaces.infoText = infoText;
    }

    public static void update() {
        interfaces.progressBarLife.setProgress((double) interfaces.readLife() / 100);
        interfaces.progressBarOxygen.setProgress((double) interfaces.readOxygen() / 100);
        interfaces.waveTimeLabel.setText(Long.toString(interfaces.readWaveTime()));
        interfaces.waveNumberValue.setText(Integer.toString(interfaces.readWaveNumber()));
        
        String output = interfaces.requestOutputText();
        
        if (!lastOutput.equals(output)) {
            interfaces.infoText.setText(output);
            lastOutput = output;
            interfaces.infoText.setScrollTop(10000);
            interfaces.infoText.positionCaret(output.length());
        }
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
            outputText.appendText(textToString(consoleText));
            outputText.setScrollTop(10000);

            String commandOutput = interfaces.requestRunCommand(inputText.getText());
            interfaces.infoText.setText(commandOutput);
            interfaces.infoText.setScrollTop(10000);
            interfaces.infoText.positionCaret(commandOutput.length());
            lastOutput = commandOutput;

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
