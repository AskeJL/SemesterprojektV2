package presentation;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presentation.menu.MenuViewController;

/**
 * The main controller of all the view from the presentation layer. This will
 * control which views to update and initialize.
 */
public class ViewManager {
    
    private final static String MENU_PATH = "menu/menuView.fxml"; 
    private final static String SETTINGS_PATH = "menu/settings/settingsView.fxml";
    private final static String HIGH_SCORE_PATH = "menu/highscore/highscoreView.fxml";
    private final static String GAME_VIEW_PATH = "game/gameView.fxml";
    private final static String GAME_OVER_PATH = "game/gameover/GameOverView.fxml";
    
    
    private static Stage currentStage;
    
    /**
     * Initialize the necessary scene.
     */
    static void init() throws IOException {
        currentStage.setTitle("Spaceman Spice");
        currentStage.show();
        MenuViewController.init();
    }

    /**
     * Update a particular view. 
     */
    static void update() {
        
    }
    
    static void setStage(Stage stage) {
        currentStage = stage;
    }
    
    public void loadView(String FXMLFile) throws IOException{
        Scene scene = new Scene(FXMLLoader.load(getClass().getResource(FXMLFile)));
        currentStage.setScene(scene);
        currentStage.show();
        System.out.println("it runs");
    }
    
    public String getMenuPath(){
        return MENU_PATH;
    }
    
    public String gethighScorePath(){
        return HIGH_SCORE_PATH;
    }
    
    public String getgameViewPath(){
        return GAME_VIEW_PATH;
    }
    
    public String getSettingsViewPath(){
        return SETTINGS_PATH;
    }
    
    public String getGameOverPth(){
        return GAME_OVER_PATH;
    }
    
    public static Stage getCurrentStage(){
        return currentStage;
    }
}
