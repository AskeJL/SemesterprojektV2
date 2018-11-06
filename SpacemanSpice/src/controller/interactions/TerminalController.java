package controller.interactions;

import controller.game.Controller;
import controller.locations.Location;
import controller.locations.LocationsController;
import controller.locations.Room;

public class TerminalController extends Controller {

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

    public static Room getCurrentRoom() {
        return LocationsController.getCurrentRoom();
    }

    public static Location getCurrentLocation() {
        return LocationsController.getCurrentLocation();
    }
}
