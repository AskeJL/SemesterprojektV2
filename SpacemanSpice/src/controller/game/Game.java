package controller.game;

import controller.interactions.TerminalController;
import controller.locations.LocationsController;
import controller.resources.ResourcesController;
import controller.systems.SystemsController;


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
        TerminalController.init();
        ResourcesController.init();
        SystemsController.init();
    }

    /**
     * Loops through all the controllers.
     */
    private static void loop() {
        while (running) {
            LocationsController.update();
            TerminalController.update();
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
