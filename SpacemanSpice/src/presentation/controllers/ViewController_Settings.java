package presentation.controllers;

import domain.DomainRequester;
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

public class ViewController_Settings extends ViewController implements Initializable {

    DomainRequester domain = new DomainRequester();
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
        domain.setDifficultyEasy();
    }

    @FXML
    private void difficultyHardHandler(ActionEvent event) {
        domain.setDifficultyHard();
    }

    @FXML
    private void difficultyMenuHandler(ActionEvent event) {
    }

    @FXML
    private void backButtonHandler(ActionEvent event) throws IOException {
        guiManager.loadView(guiManager.getMenuPath());
    }

    @Override
    public void update() {
        // Nothing to update
    }
    
}
