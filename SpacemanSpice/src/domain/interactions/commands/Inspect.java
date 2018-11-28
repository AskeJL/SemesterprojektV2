package domain.interactions.commands;

import data.AssetType;
import data.Data;
import domain.interactions.Command;
import domain.locations.LocationsController;

/**
 * This command is responsible for inspecting a room when prompted. Upon
 * calling, the terminal will print the associated description for the current
 * room.
 *
 * It will refer to the description files specified in {@link data.AssetType}.
 * Because of this reference, this class also implements the
 * {@link data.read.DataReader} interface.
 */
public class Inspect extends Command {

    private final Data dataAccess = new Data();
    private final LocationsController locationsController;
    
    public Inspect() {
        super("inspect", "Inspect the room you are in.", false);
        
        locationsController = interactionsController.getLocationsController();
    }

    @Override
    protected void checkAvailableParameters() {
        // Nothing to check
    }

    /**
     * Reads the description file associated with the current room.
     *
     * @see data.read.DataReader
     */
    @Override
    protected void run() {
        String data = "";
        for (String string : this.dataAccess.requestData(AssetType.DESCRIPTION, locationsController.getCurrentRoom().getName() + ".txt")) {
            data += string;
        }
        output.println(data);
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Inspect: name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

    @Override
    public void helpInfo() {
        output.println("Inspect the room. This will give you an idea of the surroundings you are currently in.");
    }

}
