package presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.controllers.ViewController;

/**
 * The main controller of all the view from the presentation layer. This will
 * control which views to update and initialize.
 */
public class GUIManager extends ViewManager {

    private final static String PATH_MENU = "fxml/menuView.fxml";
    private final static String PATH_SETTINGS = "fxml/settingsView.fxml";
    private final static String PATH_HIGH_SCORE = "fxml/highscoreView.fxml";
    private final static String PATH_GAME_VIEW = "fxml/gameView.fxml";
    private final static String PATH_GAME_OVER = "fxml/GameOverView.fxml";

    private final static String[] FXML_PATHS = {
        PATH_MENU,
        PATH_SETTINGS,
        PATH_HIGH_SCORE,
        PATH_GAME_VIEW,
        PATH_GAME_OVER
    };

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
        for (ViewController controller : VIEW_CONTROLLERS) {
            if (currentController.equals(controller)) {
                controller.update();
            }
        }
    }

    private void loadControllers() {
        for (String path : FXML_PATHS) {
            try {
                FXMLLoader loader = new FXMLLoader();
                Pane p = loader.load(getClass().getResource(path).openStream());
                ViewController controller = loader.getController();

                if (controller != null) {
                    controller.setPath(path);
                    VIEW_CONTROLLERS.add(controller);
                }
            } catch (IOException ex) {
                System.out.println("Failed to load controller for FXML: " + path + " : " + ex);
            }
        }

        for (ViewController controller : VIEW_CONTROLLERS) {
            controller.setManager(this);
        }
    }

    public void loadView(String FXMLFile) {
        try {
            FXMLLoader loader = new FXMLLoader();
            Pane p = loader.load(getClass().getResource(FXMLFile).openStream());
            ViewController controller = loader.getController();
            
            currentStage.setScene(new Scene(FXMLLoader.load(getClass().getResource(FXMLFile))));
            controller.setPath(FXMLFile);
            currentController = controller;

        } catch (IOException ex) {
            System.out.println("Failed to find the given FXML file: " + FXMLFile + " " + ex);
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

    public String gethighScorePath() {
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
