/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.menu;

import domain.interactions.InteractionsRequest;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.ViewManager;

/**
 * FXML Controller class
 *
 * @author askel
 */
public class MenuViewController implements Initializable, InteractionsRequest {

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

    private static ViewManager vman = new ViewManager();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public static void init() throws IOException {
        vman.loadView(vman.getMenuPath());
    }

    @FXML
    private void onPlayHandler(ActionEvent event) throws IOException {
        vman.loadView(new ViewManager().getGameViewPath());
        ViewManager.setLastPath(vman.getGameViewPath());
    }

    @FXML
    private void onSettingsHandler(ActionEvent event) throws IOException {
        vman.loadView(new ViewManager().getSettingsViewPath());
    }

    @FXML
    private void onHighScore(ActionEvent event) throws IOException {
        vman.loadView(vman.gethighScorePath());
    }

    @FXML
    private void onQuitHandler(ActionEvent event) {
        this.requestQuit();
        ViewManager.getCurrentStage().close();
    }

}
