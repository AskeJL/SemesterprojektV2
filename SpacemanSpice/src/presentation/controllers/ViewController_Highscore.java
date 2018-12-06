package presentation.controllers;

import presentation.GUIManager;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ViewController_Highscore extends ViewController implements Initializable {

    @FXML
    private ListView<String> highscoreLIst;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> highscoreLIst = new ArrayList<>();
        
    }    

    @FXML
    private void onBackHandler(ActionEvent event) throws IOException {
        guiManager.loadView(guiManager.getMenuPath());
    }

    @Override
    public void update() {
        // Nothing to update.
    }
    
}
