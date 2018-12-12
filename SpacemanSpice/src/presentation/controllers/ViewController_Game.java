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
import presentation.draw.DrawController;

/**
 * FXML Controller class
 *
 * @author sbang
 */
public class ViewController_Game extends ViewController implements Initializable {

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
    private DrawController drawController = new DrawController();
    private GraphicsContext gc;

    private final DomainReader reader = new DomainReader();
    private final DomainRequester requester = new DomainRequester();

    private boolean initialized = false;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = canvasMap.getGraphicsContext2D();

        drawController = (DrawController) guiManager.getGameElementGroup().getGameElement(DrawController.class);
    }

    @Override
    public void update() {
        if (!initialized) {
            drawController.setup();
            drawController.drawLocation();
            drawController.drawPlayer();
            
            initialized = true;
        }

        requester.startSounds();
        progressBarLife.setProgress((double) reader.readLifeValue() / 100);
        if (reader.readLifeValue() <= 50 && reader.readLifeValue() > 0) {
           requester.playSireenSound();
        } else if(reader.readLifeValue() == 0){
            guiManager.loadView(guiManager.getGameOverPath());
            requester.stopSounds();
        }
        progressBarOxygen.setProgress((double) reader.readOxygenValue() / 100);
        if (reader.readOxygenValue() == 0) {
            guiManager.loadView(guiManager.getGameOverPath());
            requester.stopSounds();
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

        requester.playGameMusic();
        requester.playLocationSound();
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

    @FXML
    private void keyPressedHandler(KeyEvent event) {
        switch (event.getCode()) {
            case SPACE:
                event.consume();
                drawController.interact();
                break;
            case UP:
                event.consume();
                drawController.movePlayerUP();
                break;
            case DOWN:
                event.consume();
                drawController.movePlayerDown();
                break;
            case LEFT:
                event.consume();
                drawController.movePlayerLeft();
                break;
            case RIGHT:
                event.consume();
                drawController.movePlayerRight();
                break;
            case ENTER:
                inputText.requestFocus();
                break;
            case ESCAPE:
                event.consume();
                canvasMap.requestFocus();
                break;
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
