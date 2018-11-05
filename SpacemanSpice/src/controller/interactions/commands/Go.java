package controller.interactions.commands;

import controller.interactions.Command;
import controller.interactions.Commands;
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

        for (Exit exit : TerminalController.getCurrentLocation().getExits()) {
            if (exit.getFromRoom().getName().equals(TerminalController.getCurrentRoom().getName())) {
                parameters.add(exit.getDirection().name().toLowerCase());
            }
        }

        for (Exit exit : roomExits) {
            parameters.add(exit.getDirection().name().toLowerCase());
        }

        super.setAvailableParameters(parameters);
    }

    @Override
    public void run() {
        Room nextRoom;
        Location nextLocation;
        Exit exitTo = null;

        for (Exit exit : TerminalController.getCurrentLocation().getExits()) {
            if (exit.getDirection().name().toLowerCase().equals(super.getCurrentParameter())) {
                exitTo = exit;
            }
        }

        System.out.println(exitTo);

        if (exitTo == null) {
            nextRoom = TerminalController.getCurrentRoom().getExit(super.getCurrentParameter()).getFromRoom();
            nextLocation = TerminalController.getCurrentLocation();
        } else {
            nextRoom = exitTo.getToRoom();
            nextLocation = exitTo.getToLocation();
        }

        TerminalController.setCurrentRoom(nextRoom);
        TerminalController.setCurrentLocation(nextLocation);

        System.out.print("You went " + super.getCurrentParameter());
        System.out.println(". You have entered " + TerminalController.getCurrentRoom().getName());
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Go: name[" + super.getName() + "] description[" + super.getDescription() + "] para[" + super.getCurrentParameter() + "]";
    }
}
