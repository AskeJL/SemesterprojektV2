package domain.game;

import domain.interactions.InteractionsController;
import domain.locations.LocationsController;
import domain.resources.ResourcesController;
import domain.systems.SystemsController;
import domain.tutorial.TutorialController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Methods to initialize and update the game
 */
public class Game extends Application {

    private final boolean runTests = true;
    private boolean running = true;
    private List<Controller> controllers = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        controllers.add(new TutorialController(this));
        controllers.add(new LocationsController(this));
        controllers.add(new ResourcesController(this));
        controllers.add(new InteractionsController(this));
        controllers.add(new SystemsController(this));

        initialize();
        //loop();
    }

    /**
     * Initializes all the controllers.
     */
    private void initialize() throws IOException {
        new DomainOutput(this).init();

        for (Controller c : controllers) {
            c.init();
        }

        if (runTests) {
            for (Controller c : controllers) {
                System.out.println("\nRunning tests for " + c + ":");
                if(!c.runTest()) {
                    System.out.println("FAILED test for " + c + "\n");
                } else {
                    System.out.println("PASSED test for " + c + "\n");
                }
            }
        }
    }

    /**
     * Loops through all the controllers.
     */
    private void loop() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (running) {
                    for (Controller c : controllers) {
                        c.update();
                    }
                }
            }
        }.start();
    }

    public <T extends Controller> Controller getController(T t) {
        for (Controller c : controllers) {
            if (c.getClass().getCanonicalName().equals(t.getClass().getCanonicalName())) {
                return c;
            }
        }

        return null;
    }

    /**
     * Set if the game is running.
     *
     * @param isRunning
     */
    void setRunning(boolean isRunning) {
        this.running = isRunning;
    }

    boolean isRunning() {
        return this.running;
    }

    List<Controller> getControllers() {
        return this.controllers;
    }
}
