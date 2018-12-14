package domain.interactions.commands;

import data.AssetType;
import data.Data;
import domain.DomainReader;
import domain.interactions.Command;
import domain.locations.LocationsManager;

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
    private final DomainReader reader = new DomainReader();
    private final LocationsManager locationsManager;
    
    public Inspect(LocationsManager locations) {
        super("inspect", "Inspect the room you are in.", false);
        
        this.locationsManager = locations;
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
        for (String string : this.dataAccess.readData(AssetType.DESCRIPTION, locationsManager.getCurrentLocation().getName() + ".txt")) {
            data += "\n" + string;
        }
        reader.storeln(data);
    }

    @Override
    public String toString() {
        return "domain.interactions.commands.Inspect: name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

    @Override
    public void helpInfo() {
        reader.storeln("Inspect the room. This will give you an idea of the surroundings you are currently in.");
    }

}
