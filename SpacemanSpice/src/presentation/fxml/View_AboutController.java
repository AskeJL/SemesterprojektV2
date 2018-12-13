/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */
package presentation.fxml;

import data.AssetType;
import data.Data;
import domain.sound.SoundManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import presentation.controllers.ViewController;
import presentation.controllers.ViewController_Menu;

/**
 * FXML Controller class
 *
 * @author sbang
 */
public class View_AboutController extends ViewController implements Initializable {

    @FXML
    private ImageView background;
    @FXML
    private AnchorPane foreground;
    @FXML
    private ImageView aboutBackground;
    @FXML
    private TextArea about;
    
    private ViewController_Menu menu;
    private boolean initialized = false;
    
    private ImageView earth;
    private ImageView earth_Debris_01;
    private ImageView earth_Debris_02;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        background.setImage(new Image("presentation/controllers/background-titled.png", true));
        
        prepareAnimation();
        
        guiManager.getCurrentStage().setWidth(1280);
        guiManager.getCurrentStage().setHeight(720);
        
        Data data = new Data();
        String text = "";
        for(String line : data.readData(AssetType.TEXT, "about.txt")) {
            text += line + "\n";
        }
        about.setText(text);
    }

    @Override
    public void update() {
        if(!initialized) {
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
        ImageView earthBackground = new ImageView(new Image("presentation/controllers/earthBackground.png"));
        earth = new ImageView(new Image("presentation/controllers/earth.png"));
        earth_Debris_01 = new ImageView(new Image("presentation/controllers/Debris_01.png"));
        earth_Debris_02 = new ImageView(new Image("presentation/controllers/Debris_02.png"));

        prepareImage(earthBackground, -500, 280, 0.5, 0.5);
        prepareImage(earth, -380, 420, 0.5, 0.5);
        prepareImage(earth_Debris_01, -350, 420, 0.75, 0.75);
        prepareImage(earth_Debris_02, -350, 420, 0.75, 0.75);

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
    private void onBack(ActionEvent event) {
        new SoundManager().getSoundPlayer().playButtonClickSound();
        guiManager.loadView(guiManager.getMenuPath());
    }

    @FXML
    private void hover(MouseEvent event) {
        new SoundManager().getSoundPlayer().playButtonHoverSound();
    }
}
