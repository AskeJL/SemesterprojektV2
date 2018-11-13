package controller.game;

public class Controller {

    protected Controller(){}
    
    /**
     * For initialising the controller. All the classes that needs to be
     * initialised is initialised here.
     */
    public static void init() {
        System.out.println("Not implemented");
    }

    /**
     * An update that is continously called from Game.
     */
    public static void update() {
        System.out.println("Not implemented");
    }
    
    protected static void setRunning(boolean isRunning) {
        Game.setRunning(isRunning);
    }
}
