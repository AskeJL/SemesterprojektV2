package domain.game;

import domain.interactions.InteractionsController;
import domain.locations.LocationsController;
import domain.resources.ResourcesController;
import domain.systems.SystemsController;


/**
 * Methods to initialise and update the game
 */
public class Game {

    private static boolean running = true;

    private Game() {
    }

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
        LocationsController.init();
        InteractionsController.init();
        ResourcesController.init();
        SystemsController.init();
    }

    /**
     * Loops through all the controllers.
     */
    private static void loop() {
        while (running) {
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
