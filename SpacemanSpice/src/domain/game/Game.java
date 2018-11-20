package domain.game;

import domain.interactions.InteractionsController;
import domain.locations.LocationsController;
import domain.resources.ResourcesController;
import domain.systems.SystemsController;
import domain.tutorial.TutorialController;
import presentation.presentationInit;
import presentation.presentationUpdate;

/**
 * Methods to initialize and update the game
 */
public class Game implements presentationInit, presentationUpdate{

    private static boolean running = true;
    
    private Game() {}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        init();
        loop();
    }

    /**
     * Initializes all the controllers.
     */
    private static void init() {
        new Game().initRequest(0);
        
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
        while (running) {
            new Game().updateRequest();
            
            TutorialController.update();
            LocationsController.update();
            InteractionsController.update();
            ResourcesController.update();
            SystemsController.update();
        }
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
