/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.game.gameover;

import data.AssetType;
import data.write.DataWriter;
import domain.interactions.InteractionsRequest;
import domain.locations.LocationsController;
import domain.resources.ResourcesController;
import domain.systems.SystemsController;
import domain.systems.SystemsReader;
import domain.tutorial.TutorialController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import presentation.ViewManager;

/**
 * FXML Controller class
 *
 * @author askel
 */
public class GameOverViewController implements Initializable, InteractionsRequest, SystemsReader, DataWriter {

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
        this.scoreField.setText("Your score was " + this.readScore());
        List <String> score = new ArrayList<>();
        score.add(Integer.toString(this.readScore()));
        this.writeData(AssetType.SCORE, "highscore.txt",score);
        ResourcesController.setOxygen(100);
        ResourcesController.setLife(100);
        SystemsController.setNumberOfWaves(0);
        SystemsController.setPlayerReady(false);
        SystemsController.init();
        LocationsController.init();
        TutorialController.init();
    }    

    @FXML
    private void menuButtonHandler(ActionEvent event) throws IOException {
        ViewManager menu = new ViewManager();
        menu.loadView(menu.getMenuPath());
    }

    @FXML
    private void quitButtonHandler(ActionEvent event) {
        this.requestQuit();
        ViewManager.getCurrentStage().close();
    }

    @FXML
    private void initialize(ActionEvent event) {
        this.scoreField.setText("Your score was " + this.readScore());
    }
    
}
