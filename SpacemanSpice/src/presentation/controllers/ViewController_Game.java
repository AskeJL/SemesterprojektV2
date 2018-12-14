package presentation.controllers;

import data.AssetType;
import data.Data;
import domain.DomainReader;
import domain.DomainRequester;
import domain.interactions.commands.Continue;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import presentation.draw.DrawController;
import domain.sound.SoundPlayer;
import domain.tutorial.TutorialManager;

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
    private Label waveTimeValue;
    @FXML
    private ProgressBar progressBarOxygen;
    @FXML
    private Canvas canvasMap;
    @FXML
    private TextField inputText;
    @FXML
    private TextArea infoText;
    @FXML
    private AnchorPane foreground;
    @FXML
    private ImageView background;
    @FXML
    private ImageView terminalLamp;
    @FXML
    private ImageView canisterLamp;
    @FXML
    private Label o2Canister;
    @FXML
    private Label hpCanister;
    @FXML
    private ImageView waveImage;
    @FXML
    private ImageView timeImage;
    @FXML
    private ImageView terminalImage;
    @FXML
    private ImageView canisterImage;

    private int terminalLampCounter = 0;
    private int canisterLampCounter = 0;
    private boolean terminalLampOn = true;
    private boolean canisterLampOn = true;

    private static String lastOutput = "";

    private final ArrayList<String> consoleText = new ArrayList<>();
    private DrawController drawController = new DrawController();
    private GraphicsContext gc;

    private final DomainReader reader = new DomainReader();
    private final DomainRequester requester = new DomainRequester();

    private boolean initialized = false;

    private ImageView earth;
    private ImageView earth_Debris_01;
    private ImageView earth_Debris_02;

    private ViewController_Menu menu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = canvasMap.getGraphicsContext2D();

        background.setImage(new Data().readImage(AssetType.UI, "background.png"));
        waveImage.setImage(new Data().readImage(AssetType.UI, "metalPanel_numberDisplay.png"));
        timeImage.setImage(new Data().readImage(AssetType.UI, "metalPanel_numberDisplay.png"));
        terminalImage.setImage(new Data().readImage(AssetType.UI, "terminal.png"));
        canisterImage.setImage(new Data().readImage(AssetType.UI, "canisters.png"));

        prepareAnimation();

        guiManager.getCurrentStage().setWidth(1280);
        guiManager.getCurrentStage().setHeight(720);

        drawController = (DrawController) guiManager.getGameElementGroup().getGameElement(DrawController.class);
    }

    @Override
    public void update() {
        if (!initialized) {
            drawController.setup();
            drawController.drawLocation();
            drawController.drawPlayer();

            menu = (ViewController_Menu) guiManager.getController(guiManager.getMenuPath());

            initialized = true;
        }

        requester.requestStartSounds();
        progressBarLife.setProgress((double) reader.readLifeValue() / 100);
        if (reader.readLifeValue() <= 50 && reader.readLifeValue() > 0) {
           requester.requestSirenSound();
        } else if(reader.readLifeValue() == 0){
            guiManager.loadView(guiManager.getGameOverPath());
            requester.requestStopSounds();
        }
        progressBarOxygen.setProgress((double) reader.readOxygenValue() / 100);
        if (reader.readOxygenValue() == 0) {
            guiManager.loadView(guiManager.getGameOverPath());
            requester.requestStopSounds();
        }
        waveTimeValue.setText(Long.toString(reader.readRemainingTime()));
        waveNumberValue.setText(Integer.toString(reader.readNumberOfWaves()));
        
        if (terminalLampOn) {
            if (terminalLampCounter == 1) {
                terminalLamp.setImage(new Data().readImage(AssetType.UI, "squareGreen-lit.png"));
            }
            terminalLampCounter = terminalLampCounter < 200 ? terminalLampCounter + 1 : 0;
            if (terminalLampCounter == 0) {
                terminalLamp.setImage(new Data().readImage(AssetType.UI, "squareGreen.png"));
                terminalLampOn = false;
            }
        }
        
        if (canisterLampOn || reader.readLifeValue() < 50 || reader.readOxygenValue() < 50) {
            if (canisterLampCounter == 1 || canisterLampCounter == 200) {
                canisterLamp.setImage(new Data().readImage(AssetType.UI, "squareRed-lit.png"));
            }
            canisterLampCounter = canisterLampCounter < 400 ? canisterLampCounter + 1 : 0;
            if (canisterLampOn || canisterLampCounter == 100 || canisterLampCounter == 300) {
                canisterLamp.setImage(new Data().readImage(AssetType.UI, "squareRed.png"));
            }
            canisterLampOn = false;
        }

        String output = reader.readOutput();

        if (output != null && !lastOutput.equals(output)) {
            infoText.setText(output);
            lastOutput = output;
            infoText.setScrollTop(10000);
            infoText.positionCaret(output.length());
            terminalLampOn = true;
        }

        requester.requestGameMusic();
        requester.requestLocationSound();

        earth.rotateProperty().set(menu.getEarthCount());
        menu.setEarthCount(menu.getEarthCount() > 360 ? 0 : menu.getEarthCount() + 0.005);

        earth_Debris_01.rotateProperty().set(menu.getDebris01Count());
        menu.setDebris01Count(menu.getDebris01Count() > 360 ? 0 : menu.getDebris01Count() + 0.02);

        earth_Debris_02.rotateProperty().set(menu.getDebris02Count());
        menu.setDebris02Count(menu.getDebris02Count() > 360 ? 0 : menu.getDebris02Count() + 0.01);
    }

    public void prepareAnimation() {
        ImageView earthBackground = new ImageView(new Data().readImage(AssetType.UI, "earthBackground.png"));
        earth = new ImageView(new Data().readImage(AssetType.UI, "earth.png"));
        earth_Debris_01 = new ImageView(new Data().readImage(AssetType.UI, "Debris_01.png"));
        earth_Debris_02 = new ImageView(new Data().readImage(AssetType.UI, "Debris_02.png"));

        prepareImage(earthBackground, -500, 280, 0.5, 0.5);
        prepareImage(earth, -380, 420, 0.5, 0.5);
        prepareImage(earth_Debris_01, -350, 420, 0.75, 0.75);
        prepareImage(earth_Debris_02, -350, 420, 0.75, 0.75);

        foreground.getChildren().add(earthBackground);
        foreground.getChildren().add(earth);
        foreground.getChildren().add(earth_Debris_01);
        foreground.getChildren().add(earth_Debris_02);
    }

    public void prepareImage(ImageView image, double xPos, double yPos, double xScale, double yScale) {
        image.setScaleX(xScale);
        image.setScaleY(yScale);
        image.setTranslateX(xPos);
        image.setTranslateY(yPos);
    }

    @FXML
    private void enterPressedHandler(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {

            if (inputText.getText().equals("")) {
                return;
            }
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
            case C:
                event.consume();
                System.out.println(guiManager.getManager(TutorialManager.class));
                ((TutorialManager)guiManager.getManager(TutorialManager.class)).setContinue(true);
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
