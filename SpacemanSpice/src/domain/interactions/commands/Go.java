package domain.interactions.commands;

import domain.DomainReader;
import domain.interactions.Command;
import domain.locations.Exit;
import domain.locations.LocationsManager;
import java.util.ArrayList;
import java.util.List;

/**
 * This command is responsible for moving through rooms and locations.
 */
public class Go extends Command {
    /**
     * The current exits based on the
     * {@link domain.locations.LocationsController#getCurrentRoom() current room}.
     */
    private final List<Exit> CURRENT_EXITS = new ArrayList<>();

    private final LocationsManager locationsManager;
    private DomainReader reader = new DomainReader();
    
    public Go(LocationsManager locations) {
        super("go", "Walk the player in a direction. [North, South, West, East]", true);

        super.addParameter("north");
        super.addParameter("west");
        super.addParameter("east");
        super.addParameter("south");
        
        this.locationsManager = locations;
    }

    @Override
    public void checkAvailableParameters() {
        CURRENT_EXITS.clear();
        ArrayList<Exit> roomExits = locationsManager.getCurrentRoom().getExits();
        ArrayList<String> parameters = new ArrayList<>();

        for (Exit exit : locationsManager.getCurrentLocation().getExits()) {
            if (exit.getFromRoom().getName().equals(locationsManager.getCurrentRoom().getName())) {
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
            locationsManager.setCurrentLocation(exitTo.getToLocation());
            locationsManager.setCurrentRoom(exitTo.getToRoom());
        } else if (exitTo != null) {
            locationsManager.setCurrentRoom(exitTo.getFromRoom());
        }

        reader.storeln("Current room: " + locationsManager.getCurrentRoom().getName());
    }

    @Override
    public String toString() {
        return "domain.interactions.commands.Go: name[" + super.getName() + "] description[" + super.getDescription() + "] para[" + super.getCurrentParameter() + "]";
    }

    @Override
    public void helpInfo() {
        reader.storeln("The go command is used to move through rooms.\ngo <direction>");
    }
}
