package presentation.controllers;

import domain.DomainReader;
import domain.DomainRequester;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import static presentation.controllers.ViewController.guiManager;

/**
 * FXML Controller class
 *
 * @author sbang
 */
public class GameViewController extends ViewController implements Initializable {

    @FXML
    private ProgressBar progressBarLife;
    @FXML
    private Label waveLabel;
    @FXML
    private Label waveNumberValue;
    @FXML
    private Label timeLabel;
    @FXML
    private Label waveTimeLabel;
    @FXML
    private ProgressBar progressBarOxygen;
    @FXML
    private Canvas canvasMap;
    @FXML
    private TextArea outputText;
    @FXML
    private TextField inputText;
    @FXML
    private TextArea infoText;

    private static String lastOutput = "";

    private final ArrayList<String> consoleText = new ArrayList<>();
    private GraphicsContext gc;

    private final DomainReader reader = new DomainReader();
    private final DomainRequester requester = new DomainRequester();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @Override
    public void update() {
        progressBarLife.setProgress((double) reader.readLifeValue() / 100);
        if (reader.readLifeValue() == 0) {
            guiManager.loadView(guiManager.getGameOverPath());
        }
        progressBarOxygen.setProgress((double) reader.readOxygenValue() / 100);
        if (reader.readOxygenValue() == 0) {
            guiManager.loadView(guiManager.getGameOverPath());
        }
        waveTimeLabel.setText(Long.toString(reader.readRemainingTime()));
        waveNumberValue.setText(Integer.toString(reader.readNumberOfWaves()));

        String output = reader.readOutput();

        if (output != null && !lastOutput.equals(output)) {
            infoText.setText(output);
            lastOutput = output;
            infoText.setScrollTop(10000);
            infoText.positionCaret(output.length());
        }
    }

    @FXML
    private void enterPressedHandler(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            if (inputText.getText().equals("")) {
                return;
            }
            consoleText.add(inputText.getText());
            outputText.setText(textToString(consoleText));
            outputText.setScrollTop(10000);

            requester.requestRunCommand(inputText.getText());
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

    public GraphicsContext getGraphicsContext() {
        return gc;
    }
}
