package controller.game;

import controller.interactions.TerminalController;
import controller.locations.LocationsController;

/**
 *
 * @author sbang
 */
public abstract class Game {

    private static boolean running = true;
    
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
    }

    /**
     * Loops through all the controllers.
     */
    private static void loop() {
        while (running) {
            LocationsController.update();
            TerminalController.update();
        }
    }
    
    /**
     * Set if the game is running. 
     * @param isRunning 
     */
    protected static void setRunning(boolean isRunning) {
        Game.running = isRunning;
    }
    
    protected static boolean isRunning() {
        return Game.running;
    }
}
