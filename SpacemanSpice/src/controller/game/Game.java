package controller.game;

import controller.interactions.TerminalController;
import controller.locations.LocationsController;

/**
 *
 * @author sbang
 */
public class Game {

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
    static void init() {
        LocationsController.init();
        TerminalController.init();
    }

    /**
     * Loops through all the controllers.
     */
    static void loop() {
        while (running) {
            LocationsController.update();
            TerminalController.update();
        }
    }
    
    /**
     * Set if the game is running. 
     * @param isRunning 
     */
    public static void setRunning(boolean isRunning) {
        Game.running = isRunning;
    }
    
    public static boolean isRunning() {
        return Game.running;
    }
}
