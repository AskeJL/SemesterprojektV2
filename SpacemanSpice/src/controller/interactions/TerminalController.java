package controller.interactions;

import controller.locations.Location;
import controller.locations.LocationsController;
import controller.locations.Room;

public class TerminalController {

    /**
     * Initialize the terminal. This is required before doing anything else with
     * the class.
     */
    public static void initTerminal() {
        LocationsController.init();
        
        Commands.init();
        while (true) {
            Command command = Parser.getCommand();
            if (command != null) {
                command.run();
            }
        }
    }

    public static void setCurrentRoom(Room room) {
        LocationsController.setCurrentRoom(room);
    }
    
    public static void setCurrentLocation(Location location) {
        LocationsController.setCurrentLocation(location);
    }

    public static Room getCurrentRoom() {
        return LocationsController.getCurrentRoom();
    }
    
    public static Location getCurrentLocation() {
        return LocationsController.getCurrentLocation();
    }
}
