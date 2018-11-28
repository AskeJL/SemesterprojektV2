package domain.interactions.commands;

import data.AssetType;
import data.Data;
import domain.interactions.Command;
import domain.locations.LocationsController;
import domain.resources.ResourcesController;
import domain.systems.SystemsController;

/**
 * This command is responsible for showing resources to the player. Upon
 * calling, this could show the life of the ship, oxygen, life etc.
 *
 * It will refer to the map files specified in {@link data.AssetType}. Because
 * of this reference, this class also implements the
 * {@link data.write.DataWriter} interface.
 */
public class Show extends Command {
    
    private final Data dataAccess = new Data();
    private final LocationsController locationsController;
    
    public Show() {
        super("show", "Shows a resource to the player.", true);

        super.addParameter("oxygen");
        super.addParameter("time");
        super.addParameter("life");
        super.addParameter("map");
        super.addParameter("score");
        
        locationsController = interactionsController.getLocationsController();
    }

    /**
     * All {@link Command#availableParameters available parameters} are set to
     * all the {@link Command#parameters primary parameters}.
     */
    @Override
    protected void checkAvailableParameters() {
        super.setAvailableParameters(super.getParameters());
    }

    /**
     * Displays a resource based on the parameter called along with this
     * Command. Also calls the data-layer for map files.
     *
     * @see domain.resources.Oxygen
     * @see domain.resources.Time
     * @see domain.resources.Life
     * @see domain.systems.Score
     */
    @Override
    protected void run() {
        switch (super.getCurrentParameter()) {
            case "oxygen":
                output.println("Oxygen: " + ResourcesController.getOxygen());
            case "time":
                output.println("Time: " + ResourcesController.getRemainingTime());
            case "life":
                output.println("Life: " + ResourcesController.getLife());
            case "map":
                String data = "";
                for (String string : dataAccess.requestData(AssetType.MAP, locationsController.getCurrentRoom().getName() + ".txt")) {
                    data += string;
                }
                output.println(data);
            case "score":
                output.println(Integer.toString(SystemsController.getScore()));
        }
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Interact: name[" + super.getName() + "] description[" + super.getDescription() + "] para[" + super.getCurrentParameter() + "]";
    }

    @Override
    public void helpInfo() {
        output.println("This command displays a resource to the player, depending on its parameter."
                + "\nshow <arg>");
    }
}
