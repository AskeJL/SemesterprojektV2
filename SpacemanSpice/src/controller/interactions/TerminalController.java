package controller.interactions;

import controller.locations.LocationsController;
import controller.locations.Room;

public class TerminalController {

    private static Room currentRoom;

    /**
     * Initialize the terminal. This is required before doing anything else with
     * the class.
     */
    public static void initTerminal() {
        LocationsController.init();
        currentRoom = LocationsController.getLocations().get(0).getRooms().get(0);
        Commands.init();
        while (true) {
            Command command = Parser.getCommand();
            if (command != null) {
                command.run();
            }
        }
    }

    public static void setCurrentRoom(Room room) {
        TerminalController.currentRoom = room;
        LocationsController.setCurrentRoom(room);
    }

    public static Room getCurrentRoom() {
        return TerminalController.currentRoom;
    }
}
