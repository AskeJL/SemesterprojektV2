/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controllers;

import data.AssetType;
import data.read.DataReader;
import data.write.DataWriter;
import domain.DomainReader;
import domain.interactions.InteractionsRequest;
import data.*;
import domain.DomainRequester;
import domain.locations.LocationsManager;
import domain.resources.ResourcesManager;
import domain.systems.SystemsManager;
import domain.systems.SystemsReader;
import domain.tutorial.TutorialManager;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static presentation.controllers.ViewController.guiManager;

/**
 * FXML Controller class
 *
 * @author askel
 */
public class ViewController_GameOver extends ViewController implements Initializable {

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

    private final DomainReader reader = new DomainReader();
    private final DomainRequester requester = new DomainRequester();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        scoreField.setText("Your score was " + reader.readScore());
        
    }    
    @Override
    public void update() {
        
    }
   
    @FXML
    private void menuButtonHandler(ActionEvent event) throws IOException {
        guiManager.loadView(guiManager.getMenuPath());
        requester.requestReset();
    }

    @FXML
    private void quitButtonHandler(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void updateHighScore(ActionEvent event) {
        Data data = new Data();
        DomainReader domainReader = new DomainReader();
        
        Map<String, Integer> scoreMap = new HashMap<>();
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        List<String> userNames = new ArrayList<>();
        List<Integer> userScores = new ArrayList<>();
        List<String> sortedList = new ArrayList<>();
        List<Map.Entry<String, Integer>> listToSort = new LinkedList<>(scoreMap.entrySet());
        
        
        String currentScoreAndName = Integer.toString(domainReader.readScore()) + " " + usernameField.getText();
        List<String> readScores = data.readData(AssetType.SCORE, "highscore.txt");
        readScores.add(currentScoreAndName);
        
        for (String line : readScores) {
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(" ");
            userNames.add(scanner.next());
            if (scanner.hasNextInt()) {
                userScores.add(scanner.nextInt());
            }
        }
        for (int i = 0; i < readScores.size(); i++) {
            scoreMap.put(userNames.get(i), userScores.get(i));
        }
        Collections.sort(listToSort, new Comparator<Map.Entry<String, Integer>>() {
            public int compare (Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        
        for (Map.Entry<String, Integer> aa : listToSort) {
            sortedMap.put(aa.getKey(), aa.getValue());
        }
        
        for (String name : sortedMap.keySet()) {
            sortedList.add(name + " " + sortedMap.get(name));
        }
        data.writeData(AssetType.SCORE, "highscore.txt", sortedList);
    }
}
