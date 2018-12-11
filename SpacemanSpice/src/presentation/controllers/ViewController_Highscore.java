package presentation.controllers;

import data.AssetType;
import data.Data;
import presentation.GUIManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ViewController_Highscore extends ViewController implements Initializable {

    Data data = new Data();
    @FXML
    private ListView<String> highscoreLIst;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> scores = highscoreLIst.getItems();
        for (int i = 0; i < data.readData(AssetType.SCORE, "highscore.txt").size(); i++) {
            scores.add(data.readData(AssetType.SCORE, "highscore.txt").get(i));
        }
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