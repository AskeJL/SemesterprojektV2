/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.controllers;

import data.AssetType;
import domain.DomainReader;
import data.*;
import domain.DomainRequester;
import domain.sound.SoundManager;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import static presentation.controllers.ViewController.guiManager;

/**
 * FXML Controller class
 *
 * @author askel
 */
public class ViewController_GameOver extends ViewController implements Initializable {

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
    @FXML
    private ImageView background;
    @FXML
    private AnchorPane foreground;
    private final DomainReader reader = new DomainReader();
    private final DomainRequester requester = new DomainRequester();

    private ViewController_Menu menu;
    private boolean initialized = false;
    
    private ImageView earth;
    private ImageView earth_Debris_01;
    private ImageView earth_Debris_02;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        background.setImage(new Image("presentation/controllers/background-titled.png", true));
        
        prepareAnimation();

        guiManager.getCurrentStage().setWidth(1280);
        guiManager.getCurrentStage().setHeight(720);
        
        scoreField.setText("Your score was " + reader.readScore());
    }    
    @Override
    public void update() {
        if(!initialized) {
            menu = (ViewController_Menu) guiManager.getController(guiManager.getMenuPath());
            initialized = true;
        }
        
        earth.rotateProperty().set(menu.getEarthCount());
        menu.setEarthCount(menu.getEarthCount() > 360 ? 0 : menu.getEarthCount() + 0.005);

        earth_Debris_01.rotateProperty().set(menu.getDebris01Count());
        menu.setDebris01Count(menu.getDebris01Count() > 360 ? 0 : menu.getDebris01Count() + 0.02);

        earth_Debris_02.rotateProperty().set(menu.getDebris02Count());
        menu.setDebris02Count(menu.getDebris02Count() > 360 ? 0 : menu.getDebris02Count() + 0.01);
    }
    
    public void prepareAnimation() {
        ImageView earthBackground = new ImageView(new Image("presentation/controllers/earthBackground.png"));
        earth = new ImageView(new Image("presentation/controllers/earth.png"));
        earth_Debris_01 = new ImageView(new Image("presentation/controllers/Debris_01.png"));
        earth_Debris_02 = new ImageView(new Image("presentation/controllers/Debris_02.png"));

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
    private void menuButtonHandler(ActionEvent event) throws IOException {
        new SoundManager().getSoundPlayer().playButtonClickSound();
        guiManager.loadView(guiManager.getMenuPath());
    }

    @FXML
    private void quitButtonHandler(ActionEvent event) {
        new SoundManager().getSoundPlayer().playButtonClickSound();
        System.exit(0);
    }

    @FXML
    private void updateHighScore(ActionEvent event) {
        new SoundManager().getSoundPlayer().playButtonClickSound();
        
        DomainReader reader = new DomainReader();
        Data data = new Data();
        
        HashMap<String, Integer> scoreList = new HashMap<>();
        List<String> names = new ArrayList<>();
        List<Integer> scores = new ArrayList<>();
        
        String currentScoreString = usernameField.getText() + " " + Integer.toString(reader.readScore());
        List<String> readScores = data.readData(AssetType.SCORE, "highscore.txt");
        readScores.add(currentScoreString);

        for (String line : readScores) {
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(" ");
            names.add(scanner.next());
            if (scanner.hasNextInt()) {
                scores.add(scanner.nextInt());
            }
        }
        
        for (int i = 0; i < readScores.size(); i++) {
            scoreList.put(names.get(i), scores.get(i));
        }
        
        List<Map.Entry<String, Integer>> listToSort = new LinkedList<>(scoreList.entrySet());
        Collections.sort(listToSort, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                return (o2.getValue()).compareTo(o1.getValue()); 
            } 
        }); 
        
        List<String> sortedList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : listToSort) { 
            sortedList.add(entry.getKey() + " " + entry.getValue());
        } 
        
        data.writeData(AssetType.SCORE, "highscore.txt", sortedList);
    }

    @FXML
    private void hover(MouseEvent event) {
        new SoundManager().getSoundPlayer().playButtonHoverSound();
    }
}
