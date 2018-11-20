/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.menu.settings;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.ToggleButton;
import presentation.ViewManager;

/**
 * FXML Controller class
 *
 * @author askel
 */
public class SettingsViewController implements Initializable {

    @FXML
    private ToggleButton toggleSoundButton;
    @FXML
    private SplitMenuButton screenMenu;
    @FXML
    private MenuItem screenSmall;
    @FXML
    private MenuItem screenMedium;
    @FXML
    private MenuItem screenLarge;
    @FXML
    private SplitMenuButton difficultyMenu;
    @FXML
    private MenuItem difficultyEasy;
    @FXML
    private MenuItem difficultyHard;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void toogleSoundHandler(ActionEvent event) {
    }

    @FXML
    private void screenSmallHandler(ActionEvent event) {
    }

    @FXML
    private void screenMediumlHandler(ActionEvent event) {
    }

    @FXML
    private void screenLargelHandler(ActionEvent event) {
    }

    @FXML
    private void screenMenuHandler(ActionEvent event) {
    }

    @FXML
    private void difficultyEasyHandler(ActionEvent event) {
    }

    @FXML
    private void difficultyHardHandler(ActionEvent event) {
    }

    @FXML
    private void difficultyMenuHandler(ActionEvent event) {
    }

    @FXML
    private void backButtonHandler(ActionEvent event) throws IOException {
        String menu = new ViewManager().getMenuPath();
        new ViewManager().loadView(menu);
    }
    
}
