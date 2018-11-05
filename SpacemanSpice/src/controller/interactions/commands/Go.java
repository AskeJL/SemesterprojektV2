package controller.interactions.commands;

import controller.interactions.Command;
import controller.interactions.TerminalController;
import controller.locations.Exit;
import controller.locations.ExitDirection;
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
        ArrayList<Exit> exits = TerminalController.getCurrentRoom().getExits();
        ArrayList<String> parameters = new ArrayList<>();

        for (Exit exit : exits) {
            parameters.add(exit.getDirection().name());
        }

        super.setAvailableParameters(parameters);
    }

    @Override
    public void run() {
        System.out.println("Goes " + super.getCurrentParameter());

        Room nextRoom = TerminalController.getCurrentRoom().getExit(super.getCurrentParameter()).getRoomExit();
        
        System.out.println(nextRoom);
        TerminalController.setCurrentRoom(nextRoom);
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Go: name[" + super.getName() + "] description[" + super.getDescription() + "] para[" + super.getCurrentParameter() + "]";
    }
}
