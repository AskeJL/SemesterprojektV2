package presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presentation.controllers.ViewController;

/**
 * The main controller of all the view from the presentation layer. This will
 * control which views to update and initialize.
 */
public class GUIManager extends ViewManager {

    private final static String PATH_MENU = "fxml/view_Menu.fxml";
    private final static String PATH_SETTINGS = "fxml/view_Settings.fxml";
    private final static String PATH_HIGH_SCORE = "fxml/view_HighScore.fxml";
    private final static String PATH_GAME_VIEW = "fxml/view_Game.fxml";
    private final static String PATH_GAME_OVER = "fxml/view_GameOver.fxml";

    private final static String[] FXML_PATHS = {
        PATH_MENU,
        PATH_SETTINGS,
        PATH_HIGH_SCORE,
        PATH_GAME_VIEW,
        PATH_GAME_OVER
    };

    private final static String STYLESHEET_PATH = GUIManager.class.getResource("/presentation//fxml/css/gameViewStyleSheet.css").toExternalForm();
    
    private final static List<ViewController> VIEW_CONTROLLERS = new ArrayList<>();

    private static ViewController currentController;
    private static Stage currentStage;

    /**
     * Initialize the necessary scene.
     *
     * @param stage
     */
    public void init(Stage stage) {
        currentStage = stage;
        currentStage.setTitle("Spaceman Spice");

        loadControllers();
        loadView(PATH_MENU);
    }

    @Override
    public void update() {
        currentController.update();
    }

    private void loadControllers() {
        for (String path : FXML_PATHS) {
            try {
                FXMLLoader loader = new FXMLLoader();
                Scene scene = new Scene(loader.load(getClass().getResource(path).openStream()));
                scene.getStylesheets().add(STYLESHEET_PATH);
                ViewController controller = (ViewController) loader.getController();

                if (controller != null) {
                    controller.setPath(path);
                    controller.setScene(scene);
                    VIEW_CONTROLLERS.add(controller);
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

        for (ViewController controller : VIEW_CONTROLLERS) {
            controller.setManager(this);
        }
    }

    public void loadView(String FXMLFile) {
        for (ViewController controller : VIEW_CONTROLLERS) {
            if (controller.getPath().equals(FXMLFile)) {
                currentStage.setScene(controller.getScene());
                currentController = controller;
                currentController.getScene().getRoot().requestFocus();
            }
        }
        currentStage.show();
    }

    void setStage(Stage stage) {
        currentStage = stage;
    }

    public void setCurrentController(ViewController controller) {
        currentController = controller;
    }

    public ViewController getController(String fxml) {
        for (ViewController controller : VIEW_CONTROLLERS) {
            if (controller.getPath().equals(fxml)) {
                return controller;
            }
        }
        return null;
    }

    public ViewController getCurrentController() {
        return currentController;
    }

    public String getMenuPath() {
        return PATH_MENU;
    }

    public String getHighscorePath() {
        return PATH_HIGH_SCORE;
    }

    public String getGameViewPath() {
        return PATH_GAME_VIEW;
    }

    public String getSettingsViewPath() {
        return PATH_SETTINGS;
    }

    public String getGameOverPath() {
        return PATH_GAME_OVER;
    }

    public Stage getCurrentStage() {
        return currentStage;
    }
}
