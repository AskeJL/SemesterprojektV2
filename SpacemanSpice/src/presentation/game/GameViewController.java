package presentation.game;

import domain.game.Game;
import domain.interactions.InteractionsRequest;
import domain.resources.ResourcesController;
import domain.resources.ResourcesReader;
import domain.systems.SystemsReader;
import java.io.IOException;
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
import presentation.game.draw.DrawController;
import presentation.ViewManager;

/**
 * FXML Controller class of the game view
 * 
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

    @FXML
    private Label waveLabel;
    @FXML
    private Label timeLabel;

    private static String lastOutput = "";

    private ArrayList<String> consoleText = new ArrayList<>();
    private static GraphicsContext gc;
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
        progressBarLife.getStyleClass().add("progress-bar-life");
        interfaces.progressBarOxygen = progressBarOxygen;
        progressBarOxygen.getStyleClass().add("progress-bar-oxygen");
        interfaces.waveTimeLabel = waveTimeLabel;
        waveTimeLabel.getStyleClass().add("label-resources");
        waveLabel.getStyleClass().add("label-resources");
        timeLabel.getStyleClass().add("label-resources");
        interfaces.waveNumberValue = waveNumberValue;
        waveNumberValue.getStyleClass().add("label-resources");
        interfaces.infoText = infoText;

        gc = canvasMap.getGraphicsContext2D();

        DrawController.setup();
        DrawController.drawLocation();
        DrawController.drawPlayer();
    }

    /**
     * Function that updates the following elements on the gameView:
     * progress bar: life
     * progress bar: oxygen
     * label: wave number
     * label: wave time
     * text: information text
     */
    public static void update() {
        interfaces.progressBarLife.setProgress((double) interfaces.readLife() / 100);
        if (interfaces.readLife() == 0) {
            ViewManager gameOver = new ViewManager();
            try {
                gameOver.loadView(gameOver.getGameOverPath());
            } catch (IOException ex) {
                System.out.println("Der er en fejl. Du skal finde den! ps. Det kunne have nået at gøre med forkert file path");
                System.out.println(ex);
            }
        }
        interfaces.progressBarOxygen.setProgress((double) interfaces.readOxygen() / 100);
        if (interfaces.readOxygen() == 0) {
            ViewManager gameOver = new ViewManager();
            try {
                gameOver.loadView(gameOver.getGameOverPath());
            } catch (IOException ex) {
                System.out.println("Der er en fejl. Du skal finde den! ps. Det kunne have nået at gøre med forkert file path");
                System.out.println(ex);
            }
        }
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
     * When key is pressed, handle the following:
     * Player movement 
     * Player interaction
     * inputText and outputText.
     *
     * @param event, where event is the user input to be handled.
     */
    @FXML
    private void keyPressedHandler(KeyEvent event) {
        if (event.getCode() == KeyCode.SPACE) {
            DrawController.interact();
        }
        if (event.getCode() == KeyCode.UP) {
            DrawController.movePlayerUP();
        }
        if (event.getCode() == KeyCode.LEFT) {
            DrawController.movePlayerLeft();
        }
        if (event.getCode() == KeyCode.DOWN) {
            DrawController.movePlayerDown();
        }
        if (event.getCode() == KeyCode.RIGHT) {
            DrawController.movePlayerRight();
        }
        if (event.getCode() == KeyCode.ENTER) {
            if (inputText.getText().equals("")) {
                return;
            }
            consoleText.add(inputText.getText());
            outputText.setText(textToString(consoleText));
            outputText.setScrollTop(10000);

            String commandOutput = interfaces.requestRunCommand(inputText.getText());
            infoText.setText(commandOutput);
            infoText.setScrollTop(10000);
            infoText.positionCaret(commandOutput.length());
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

    public static GraphicsContext getGraphicsContext() {
        return gc;
    }
}
