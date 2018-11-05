package controller.interactions.commands;

import controller.interactions.Command;
import controller.interactions.TerminalController;
import controller.locations.Exit;
import controller.locations.ExitDirection;
import controller.locations.Location;
import controller.locations.Room;
import java.util.ArrayList;

public class Go extends Command {

    public Go() {
        super("go", "Walk the player in a direction. [North, South, West, East]", true);

        super.addParameter("north");
        super.addParameter("west");
        super.addParameter("east");
        super.addParameter("south");
    }

    @Override
    public void checkAvailableParameters() {
        ArrayList<Exit> roomExits = TerminalController.getCurrentRoom().getExits();
        ArrayList<String> parameters = new ArrayList<>();

        for(Exit exit : TerminalController.getCurrentLocation().getExits()) {
            System.out.println(exit);
        }

        for (Exit exit : roomExits) {
            parameters.add(exit.getDirection().name());
        }

        super.setAvailableParameters(parameters);
    }

    @Override
    public void run() {
        System.out.println("Goes " + super.getCurrentParameter());

        boolean isRoomExit = TerminalController.getCurrentRoom().getExit(super.getCurrentParameter()).isExitToRoom();

        Room nextRoom;
        Location nextLocation;

        if (isRoomExit) {
            nextRoom = TerminalController.getCurrentRoom().getExit(super.getCurrentParameter()).getRoomExit();
            nextLocation = TerminalController.getCurrentLocation();
        } else {
            nextRoom = TerminalController.getCurrentRoom();
            nextLocation = TerminalController.getCurrentRoom().getExit(super.getCurrentParameter()).getLocationExit();
        }

        TerminalController.setCurrentRoom(nextRoom);
        TerminalController.setCurrentLocation(nextLocation);
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Go: name[" + super.getName() + "] description[" + super.getDescription() + "] para[" + super.getCurrentParameter() + "]";
    }
}
