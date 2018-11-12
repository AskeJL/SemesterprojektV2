package controller.interactions;

import controller.game.Controller;
import controller.game.Game;
import controller.locations.Location;
import controller.locations.LocationsController;
import controller.locations.Room;
import controller.resources.ResourcesController;
import java.util.List;

public class TerminalController extends Controller {

    private TerminalController(){}
    
    public static void init() {
        LocationsController.init();
        Commands.init();
    }

    public static void update() {
        Command command = Parser.getCommand();
        if (command != null) {
            command.run();
        }
    }

    public static void setCurrentRoom(Room room) {
        LocationsController.setCurrentRoom(room);
    }

    public static void setCurrentLocation(Location location) {
        LocationsController.setCurrentLocation(location);
    }
    
    public static void setRunning(boolean isRunning) {
        Controller.setRunning(isRunning);
    }

    public static Room getCurrentRoom() {
        return LocationsController.getCurrentRoom();
    }

    public static Location getCurrentLocation() {
        return LocationsController.getCurrentLocation();
    }
    
    public static List<Command> getCommandWords() {
        return Commands.getCommandwords();
    }
    
    public static int getOxygen() {
        return ResourcesController.getOxygen();
    }
    
    public static long getCurrentTime() {
        return ResourcesController.getCurrentTime();
    }
    
}
