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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

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
    @FXML
    private ImageView background;
    @FXML
    private AnchorPane foreground;

    private ImageView earth;
    private ImageView earth_Debris_01;
    private ImageView earth_Debris_02;

    private static double earthRotateCount = 0;
    private static double debris01Count = 0;
    private static double debris02Count = 0;

    private final DomainRequester requester = new DomainRequester();
    @FXML
    private Button about;
    @FXML
    private VBox authors;
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

        background.setImage(new Data().readImage(AssetType.UI, "background-titled.png"));

        prepareAnimation();

        guiManager.getCurrentStage().setWidth(1280);
        guiManager.getCurrentStage().setHeight(720);
    }

    @Override
    public void update() {
        earth.rotateProperty().set(earthRotateCount);
        earthRotateCount = earthRotateCount > 360 ? 0 : earthRotateCount + 0.005;

        earth_Debris_01.rotateProperty().set(debris01Count);
        debris01Count = debris01Count > 360 ? 0 : debris01Count + 0.02;

        earth_Debris_02.rotateProperty().set(debris02Count);
        debris02Count = debris02Count > 360 ? 0 : debris02Count + 0.01;
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
    private void onPlayHandler(ActionEvent event) throws IOException {
        new SoundManager().getSoundPlayer().playButtonClickSound();
        requester.requestReset();
        guiManager.loadView(guiManager.getGameViewPath());
    }

    @FXML
    private void onSettingsHandler(ActionEvent event) throws IOException {
        new SoundManager().getSoundPlayer().playButtonClickSound();
        guiManager.loadView(guiManager.getSettingsViewPath());
    }

    @FXML
    private void onHighScore(ActionEvent event) throws IOException {
        new SoundManager().getSoundPlayer().playButtonClickSound();
        guiManager.loadView(guiManager.getHighscorePath());
    }

    @FXML
    private void onAbout(ActionEvent event) {
        new SoundManager().getSoundPlayer().playButtonClickSound();
        guiManager.loadView(guiManager.getAboutPath());
    }

    @FXML
    private void onQuitHandler(ActionEvent event) {
        new SoundManager().getSoundPlayer().playButtonClickSound();
        System.exit(0);
    }

    @FXML
    private void hover(MouseEvent event) {
        new SoundManager().getSoundPlayer().playButtonHoverSound();
    }

    public void setEarthCount(double value) {
        ViewController_Menu.earthRotateCount = value;
    }

    public void setDebris01Count(double value) {
        ViewController_Menu.debris01Count = value;
    }

    public void setDebris02Count(double value) {
        ViewController_Menu.debris02Count = value;
    }

    public double getEarthCount() {
        return ViewController_Menu.earthRotateCount;
    }

    public double getDebris01Count() {
        return ViewController_Menu.debris01Count;
    }

    public double getDebris02Count() {
        return ViewController_Menu.debris02Count;
    }
}
