/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.menu.highscore;

import data.AssetType;
import data.read.DataReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import presentation.ViewManager;
import javafx.collections.*;

/**
 * FXML Controller class
 *
 * @author askel
 */
public class HighscoreViewController implements Initializable, DataReader {

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
        ObservableList<String> scores = highscoreLIst.getItems();
        for (int i = 0; i<this.requestData(AssetType.SCORE, "highscore.txt").size(); i++)
        scores.add(this.requestData(AssetType.SCORE, "highscore.txt").get(i));
    }    

    @FXML
    private void onBackHandler(ActionEvent event) throws IOException {
        String menu = new ViewManager().getMenuPath();
        new ViewManager().loadView(menu);
    }
    
}
