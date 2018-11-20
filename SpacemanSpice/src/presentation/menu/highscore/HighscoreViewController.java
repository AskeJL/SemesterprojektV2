/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.menu.highscore;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author askel
 */
public class HighscoreViewController implements Initializable {

    @FXML
    private ListView<?> highscoreLIst;
    @FXML
    private Button backButton;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onBackHandler(ActionEvent event) throws IOException {
         GridPane pane = FXMLLoader.load(getClass().getResource("menuView.fxml"));
         Stage stage = new Stage();
         stage.setScene(new Scene(pane));
         stage.show();
    }
    
}
