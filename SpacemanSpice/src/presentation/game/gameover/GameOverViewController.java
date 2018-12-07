/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.game.gameover;

import data.AssetType;
import data.read.DataReader;
import data.write.DataWriter;
import domain.interactions.InteractionsRequest;
import domain.locations.LocationsController;
import domain.resources.ResourcesController;
import domain.systems.SystemsController;
import domain.systems.SystemsReader;
import domain.tutorial.TutorialController;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class GameOverViewController implements Initializable, InteractionsRequest, SystemsReader, DataWriter, DataReader {

    @FXML
    private Label gameOverField;
    @FXML
    private TextField scoreField;
    @FXML
    private TextField usernameField;
    @FXML
    private Button menuButton;
    @FXML
    private Button quitButton;
    @FXML
    private Button submit;



    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.scoreField.setText("Your score was " + this.readScore());
        
        ResourcesController.setOxygen(100);
        ResourcesController.setLife(100);
        SystemsController.setNumberOfWaves(0);
        SystemsController.setPlayerReady(false);
        SystemsController.init();
        LocationsController.init();
        TutorialController.init();
    }    
    
    @FXML
    public void updateHighscore(){
        List <String> score = new ArrayList<>();
        List <Integer> scoreSort = new ArrayList<>();
        List <String> scoreSorted = new ArrayList<>();
        for (int i = 0; i<this.requestData(AssetType.SCORE, "highscore.txt").size() ; i++){
        score.add(this.requestData(AssetType.SCORE, "highscore.txt").get(i));
        }
        score.add(Integer.toString(this.readScore()));
        for(int i = 0; i<score.size(); i++){
            scoreSort.add(Integer.parseInt(score.get(i)));
        }
        Collections.sort(scoreSort, Collections.reverseOrder());
        for(int i = 0; i<scoreSort.size(); i++){
            scoreSorted.add(Integer.toString(scoreSort.get(i)));
        }
        this.writeData(AssetType.SCORE , "highscore.txt",scoreSorted);
    }
       
    @FXML
    public void updateHighscore2(){
        String combined = Integer.toString(this.readScore()) + " " + usernameField.getText();
        
        try {
            FileWriter fileWriter = new FileWriter("assets\\score\\highscore2.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter outputStream = new PrintWriter(bufferedWriter);     
                outputStream.println(combined);
                outputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(GameOverViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
