package presentation.controllers;

import data.AssetType;
import data.Data;
import domain.DomainRequester;
import domain.sound.SoundManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ViewController_Settings extends ViewController implements Initializable {

    DomainRequester domain = new DomainRequester();
    @FXML
    private ToggleButton toggleSoundButton;
    @FXML
    private SplitMenuButton difficultyMenu;
    @FXML
    private MenuItem difficultyEasy;
    @FXML
    private MenuItem difficultyHard;
    @FXML
    private Button backButton;
    @FXML
    private ImageView background;
    @FXML
    private AnchorPane foreground;

    private ViewController_Menu menu;
    private boolean initialized = false;

    private ImageView earth;
    private ImageView earth_Debris_01;
    private ImageView earth_Debris_02;
    @FXML
    private VBox authors;
    @FXML
    private Label createdByLabel;
    @FXML
    private Label nameLabel1;
    @FXML
    private Label nameLabel2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        background.setImage(new Data().readImage(AssetType.UI, "background-titled.png"));

        prepareAnimation();

        guiManager.getCurrentStage().setWidth(1280);
        guiManager.getCurrentStage().setHeight(720);
    }

    @Override
    public void update() {
        if (!initialized) {
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
        ImageView earthBackground = new ImageView(new Data().readImage(AssetType.UI, "earthBackground.png"));
        earth = new ImageView(new Data().readImage(AssetType.UI, "earth.png"));
        earth_Debris_01 = new ImageView(new Data().readImage(AssetType.UI, "Debris_01.png"));
        earth_Debris_02 = new ImageView(new Data().readImage(AssetType.UI, "Debris_02.png"));

        prepareImage(earthBackground, -500, 0, 0.5, 0.5);
        prepareImage(earth, -380, 135, 0.5, 0.5);
        prepareImage(earth_Debris_01, -350, 135, 0.75, 0.75);
        prepareImage(earth_Debris_02, -350, 135, 0.75, 0.75);

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
    private void toogleSoundHandler(ActionEvent event) {
        domain.requestClickSound();
        domain.requestMuteSounds();
    }


    @FXML
    private void difficultyEasyHandler(ActionEvent event) {
        domain.requestClickSound();
        domain.requestDifficultyEasy();
    }

    @FXML
    private void difficultyHardHandler(ActionEvent event) {
        domain.requestClickSound();
        domain.requestDifficultyHard();
    }

    @FXML
    private void difficultyMenuHandler(ActionEvent event) {
        domain.requestClickSound();
    }

    @FXML
    private void backButtonHandler(ActionEvent event) throws IOException {
        domain.requestClickSound();
        guiManager.loadView(guiManager.getMenuPath());
    }

    @FXML
    private void hover(MouseEvent event) {
       domain.requestHoverSound();
    }
}
