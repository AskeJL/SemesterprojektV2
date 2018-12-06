/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controllers;

import data.AssetType;
import data.Data;
import domain.DomainReader;
import domain.DomainRequester;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
public class ViewController_GameOver extends ViewController implements Initializable {

    DomainReader score1 = new DomainReader();
    DomainRequester domain = new DomainRequester();
    
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
        scoreField.setText("You'r score was: "+ score1.readScore());
    }    

    @FXML
    private void menuButtonHandler(ActionEvent event) throws IOException {
        domain.requestReset();
        guiManager.loadView(guiManager.getMenuPath());
        this.updateHighscore();
    }

    @FXML
    private void quitButtonHandler(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void update() {
        // Nothing to update
    }
    
    private void updateHighscore(){
        Data data = new Data();
        List<String> score = new ArrayList<>();
        List<Integer> scoreSort = new ArrayList<>();
        List<String> scoreSorted = new ArrayList<>();
        for (int i = 0; i < data.requestData(AssetType.SCORE, "highscore.txt").size(); i++) {
            score.add(data.requestData(AssetType.SCORE, "highscore.txt").get(i));
        }
        score.add(Integer.toString(score1.readScore()));
        for (int i = 0; i < score.size(); i++) {
            scoreSort.add(Integer.parseInt(score.get(i)));
        }
        Collections.sort(scoreSort, Collections.reverseOrder());
        for (int i = 0; i < scoreSort.size(); i++) {
            scoreSorted.add(Integer.toString(scoreSort.get(i)));
        }
        data.writeData(AssetType.SCORE, "highscore.txt", scoreSorted);
    }
}
