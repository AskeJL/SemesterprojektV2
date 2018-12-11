package presentation.controllers;

import domain.DomainRequester;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import presentation.GUIManager;

public class ViewController_Menu extends ViewController implements Initializable {

    @FXML
    private Button highscoreButton;
    @FXML
    private Button quitButton;
    @FXML
    private Button playButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Label createdByLabel;
    @FXML
    private Label nameLabel1;
    @FXML
    private Label nameLabel2;

    private GUIManager gui;

    private final DomainRequester requester = new DomainRequester();
    @FXML
    private ImageView background;

    private ImageView earth;
    private ImageView earth_trash_01;
    private ImageView earth_trash_02;
    @FXML
    private AnchorPane foreground;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createdByLabel.getStyleClass().add("label-authors");
        nameLabel1.getStyleClass().add("label-authors");
        nameLabel2.getStyleClass().add("label-authors");

        background.setImage(new Image("presentation/controllers/background-titled.png", true));

        ImageView earthBackground = new ImageView(new Image("presentation/controllers/earthBackground.png"));
        earth = new ImageView(new Image("presentation/controllers/earth.png"));
        earth_trash_01 = new ImageView(new Image("presentation/controllers/Debris_01.png"));
        earth_trash_02 = new ImageView(new Image("presentation/controllers/Debris_02.png"));
        
        earthBackground.setScaleX(0.5);
        earthBackground.setScaleY(0.5);
        earth.setScaleX(0.5);
        earth.setScaleY(0.5);
        earth_trash_01.setScaleX(0.5);
        earth_trash_01.setScaleY(0.5);
        earth_trash_02.setScaleX(0.5);
        earth_trash_02.setScaleY(0.5);
        
        earthBackground.setTranslateX(-500);
        earthBackground.setTranslateY(280);
        earth.setTranslateX(-380);
        earth.setTranslateY(420);
        
        foreground.getChildren().add(earthBackground);
        foreground.getChildren().add(earth);
        foreground.getChildren().add(earth_trash_01);
        foreground.getChildren().add(earth_trash_02);
    }

    @FXML
    private void onPlayHandler(ActionEvent event) throws IOException {
        requester.requestReset();
        guiManager.loadView(guiManager.getGameViewPath());
    }

    @FXML
    private void onSettingsHandler(ActionEvent event) throws IOException {
        guiManager.loadView(guiManager.getSettingsViewPath());
    }

    @FXML
    private void onHighScore(ActionEvent event) throws IOException {
        guiManager.loadView(guiManager.getHighscorePath());
    }

    @FXML
    private void onQuitHandler(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void update() {
        // Nothing to update.
    }
}
