package presentation.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.GUIManager;

public class ViewController_Menu extends ViewController implements Initializable {

    @FXML
    private Button highscoreButton;
    @FXML
    private Button quitButton;
    @FXML
    private Button playButton;
    @FXML
    private Label spacemanspiceLabel;
    @FXML
    private Button settingsButton;
    @FXML
    private Label createdByLabel;
    @FXML
    private Label nameLabel1;
    @FXML
    private Label nameLabel2;

    private GUIManager gui;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spacemanspiceLabel.getStyleClass().add("label-title");
        createdByLabel.getStyleClass().add("label-authors");
        nameLabel1.getStyleClass().add("label-authors");
        nameLabel2.getStyleClass().add("label-authors");
    }

    public static void init() throws IOException {

    }

    @FXML
    private void onPlayHandler(ActionEvent event) throws IOException {
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
