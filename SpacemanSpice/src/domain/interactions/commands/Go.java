package domain.interactions.commands;

import domain.interactions.Command;
import domain.locations.Exit;
import domain.locations.LocationsController;
import java.util.ArrayList;
import java.util.List;

/**
 * This command is responsible for moving through rooms and locations.
 *
 * @author sbang
 */
public class Go extends Command {

    /**
     * The current exits based on the
     * {@link domain.locations.LocationsController#getCurrentRoom() current room}.
     */
    private final List<Exit> CURRENT_EXITS = new ArrayList<>();

    public Go() {
        super("go", "Walk the player in a direction. [North, South, West, East]", true);

        super.addParameter("north");
        super.addParameter("west");
        super.addParameter("east");
        super.addParameter("south");
    }

    @Override
    public void checkAvailableParameters() {
        CURRENT_EXITS.clear();
        ArrayList<Exit> roomExits = LocationsController.getCurrentRoom().getExits();
        ArrayList<String> parameters = new ArrayList<>();

        for (Exit exit : LocationsController.getCurrentLocation().getExits()) {
            if (exit.getFromRoom().getName().equals(LocationsController.getCurrentRoom().getName())) {
                parameters.add(exit.getDirection().name().toLowerCase());
                CURRENT_EXITS.add(exit);
            }
        }

        for (Exit exit : roomExits) {
            parameters.add(exit.getDirection().name().toLowerCase());
            CURRENT_EXITS.add(exit);
        }

        super.setAvailableParameters(parameters);
    }

    /**
     * Will go from one {@link domain.locations.Room room} to the other based on
     * the current room/locations and the {@link Command#getCurrentParameter() current parameter}.
     */
    @Override
    public void run() {
        Exit exitTo = null;

        for (Exit exit : this.CURRENT_EXITS) {
            if (exit.getDirection().name().toLowerCase().equals(super.getCurrentParameter())) {
                exitTo = exit;
            }
        }

        if (exitTo != null && exitTo.isEXIT_TO_LOCATION()) {
            LocationsController.setCurrentLocation(exitTo.getToLocation());
            LocationsController.setCurrentRoom(exitTo.getToRoom());
        } else if (exitTo != null) {
            LocationsController.setCurrentRoom(exitTo.getFromRoom());
        }

        System.out.println("Current room: " + LocationsController.getCurrentRoom().getName());
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Go: name[" + super.getName() + "] description[" + super.getDescription() + "] para[" + super.getCurrentParameter() + "]";
    }

    @Override
    public void helpInfo() {
        System.out.println("The go command is used to move through rooms.");
        System.out.println("go <direction>");
    }
}
