package presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
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
    private final static String PATH_ABOUT = "fxml/view_About.fxml";

    /**
     * A collection of all the constant paths.
     */
    private final static String[] FXML_PATHS = {
        PATH_SETTINGS,
        PATH_MENU,
        PATH_HIGH_SCORE,
        PATH_GAME_VIEW,
        PATH_GAME_OVER,
        PATH_ABOUT
    };

    /**
     * The path to the main CSS file used to design UI elements.
     */
    private final static String STYLESHEET_PATH = GUIManager.class.getResource("/presentation/fxml/css/gameViewStyleSheet.css").toExternalForm();

    /**
     * The stage currently in use. (Main window)
     */
    private Stage currentStage;

    /**
     * The {@link ViewController} in use.
     */
    private ViewController currentController;

    /**
     * All the {@link ViewController}s collected in a list.
     */
    private final List<ViewController> viewControllers = new ArrayList<>();

    /**
     * Initialize the main view. This will load the necessary
     * {@link ViewController}s using {@link #loadControllers()} and
     * {@link #loadView(java.lang.String)}.
     * <p>
     * Then proceeds to run the {@link domain.Manager#init()}.
     */
    public void init() {
        currentStage.setTitle("Spaceman Spice - Kessler Syndrome");

        new ViewController() {
            @Override
            public void update() {
                // Temp anonymous
            }
        }.setManager(this);

        loadControllers();
        loadView(PATH_MENU);

        super.init();
    }

    /**
     * Update the {@link #currentController} and run
     * {@link domain.Manager#update()}.
     */
    @Override
    public void update() {
        currentController.update();
        super.update();
    }

    /**
     * Go through all the {@link #FXML_PATHS} and initialize the
     * {@link ViewController}s then store it in {@link #viewControllers} for
     * later reference.
     * <p>
     * Provides all of the {@link ViewController}s with at reference to this
     * {@link GUIManager}.
     */
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
                    viewControllers.add(controller);
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
        for (ViewController controller : viewControllers) {
            controller.setManager(this);
        }
    }

    /**
     * Load a view based on its FXML path. This will look through the
     * {@link #viewControllers}.
     * <p>
     * Sets the resize to false so the user can't change window size.
     *
     * @param FXMLFile File to look for. (Remember file extension).
     */
    public void loadView(String FXMLFile) {
        for (ViewController controller : viewControllers) {
            if (controller.getPath().equals(FXMLFile)) {
                currentStage.setScene(controller.getScene());
                currentStage.setResizable(false);
                currentController = controller;
                currentController.getScene().getRoot().requestFocus();
                currentController.getScene().getRoot().setCursor(Cursor.DEFAULT);
            }
        }
        currentStage.show();
    }

    /**
     * Set the {@link #currentStage}.
     *
     * @param stage Stage to set.
     */
    public void setStage(Stage stage) {
        currentStage = stage;
    }

    /**
     * Set the {@link #currentController}.
     *
     * @param controller Controller to set.
     */
    public void setCurrentController(ViewController controller) {
        currentController = controller;
    }

    /**
     * Get {@link #viewControllers}.
     *
     * @return All the {@link ViewController}s in the list.
     */
    public List<ViewController> getControllers() {
        return this.viewControllers;
    }

    /**
     * Get a {@link ViewController} in the {@link #viewControllers} list based
     * on the FXML path.
     *
     * @param fxml Path to look for FXML file.
     * @return A view controller if found, null if not.
     */
    public ViewController getController(String fxml) {
        for (ViewController controller : this.viewControllers) {
            if (controller.getPath().equals(fxml)) {
                return controller;
            }
        }
        return null;
    }

    /**
     * Get {@link #currentController}.
     *
     * @return The current {@link ViewController}.
     */
    public ViewController getCurrentController() {
        return currentController;
    }

    /**
     * Get {@link #currentStage}.
     *
     * @return The current stage. (Window)
     */
    public Stage getCurrentStage() {
        return currentStage;
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

    public String getAboutPath() {
        return PATH_ABOUT;
    }
}
