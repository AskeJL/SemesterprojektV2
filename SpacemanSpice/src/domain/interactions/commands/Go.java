package domain.interactions.commands;

import domain.interactions.Command;
import domain.interactions.InteractionsController;
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
    private final LocationsController locationsController;
    
    /**
     * The current exits based on the
     * {@link domain.locations.LocationsController#getCurrentRoom() current room}.
     */
    private final List<Exit> CURRENT_EXITS = new ArrayList<>();

    public Go(InteractionsController interactions) {
        super(interactions, "go", "Walk the player in a direction. [North, South, West, East]", true);

        super.addParameter("north");
        super.addParameter("west");
        super.addParameter("east");
        super.addParameter("south");
        
        locationsController = interactionsController.getLocationsController();
    }

    @Override
    public void checkAvailableParameters() {
        CURRENT_EXITS.clear();
        ArrayList<Exit> roomExits = locationsController.getCurrentRoom().getExits();
        ArrayList<String> parameters = new ArrayList<>();

        for (Exit exit : locationsController.getCurrentLocation().getExits()) {
            if (exit.getFromRoom().getName().equals(locationsController.getCurrentRoom().getName())) {
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
            locationsController.setCurrentLocation(exitTo.getToLocation());
            locationsController.setCurrentRoom(exitTo.getToRoom());
        } else if (exitTo != null) {
            locationsController.setCurrentRoom(exitTo.getFromRoom());
        }

        output.println("Current room: " + locationsController.getCurrentRoom().getName());
    }

    @Override
    public String toString() {
        return "domain.interactions.commands.Go: name[" + super.getName() + "] description[" + super.getDescription() + "] para[" + super.getCurrentParameter() + "]";
    }

    @Override
    public void helpInfo() {
        output.println("The go command is used to move through rooms.\ngo <direction>");
    }

    @Override
    protected boolean runTest() {
        boolean passed = true;
        if(interactionsController == null) {
            passed = false;
        }
        if(locationsController == null) {
            passed = false;
        }
        return passed;
    }
}
