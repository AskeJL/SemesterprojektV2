package domain.game;

import domain.interactions.InteractionsController;
import domain.locations.LocationsController;
import domain.resources.ResourcesController;
import domain.systems.SystemsController;
import domain.tutorial.TutorialController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import presentation.presentationInit;
import presentation.presentationUpdate;

/**
 * Methods to initialize and update the game
 */
public class Game extends Application implements presentationInit, presentationUpdate {

    private static boolean running = true;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.sendStageRequest(primaryStage);
        
        initialize();
        loop();
    }

    /**
     * Initializes all the controllers.
     */
    private static void initialize() throws IOException {
        new Game().initRequest();

        TutorialController.init();
        LocationsController.init();
        ResourcesController.init();
        InteractionsController.init();
        SystemsController.init();
    }

    /**
     * Loops through all the controllers.
     */
    private static void loop() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (running) {
                    try {
                        new Game().updateRequest();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                    TutorialController.update();
                    LocationsController.update();
                    InteractionsController.update();
                    ResourcesController.update();
                    SystemsController.update();
                }
            }
        }.start();
    }

    /**
     * Set if the game is running.
     *
     * @param isRunning
     */
    static void setRunning(boolean isRunning) {
        Game.running = isRunning;
    }

    static boolean isRunning() {
        return Game.running;
    }
}
