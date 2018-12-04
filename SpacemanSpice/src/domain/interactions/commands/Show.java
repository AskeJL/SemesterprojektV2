package domain.interactions.commands;

import domain.interactions.Command;
import domain.resources.ResourcesManager;

/**
 * This command is responsible for showing resources to the player. Upon
 * calling, this could show the life of the ship, oxygen, life etc.
 *
 * It will refer to the map files specified in {@link data.AssetType}. Because
 * of this reference, this class also implements the
 * {@link data.write.DataWriter} interface.
 */
public class Show extends Command {
    
    private final ResourcesManager resourcesManager;
    
    public Show(ResourcesManager resources) {
        super("show", "Shows a resource to the player.", true);

        super.addParameter("oxygen");
        super.addParameter("time");
        super.addParameter("life");
        super.addParameter("map");
        super.addParameter("score");
        
        this.resourcesManager = resources;
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
                System.out.println("Oxygen: " + resourcesManager.getOxygen().getValue());
                break;
            case "time":
                System.out.println("Time: " + resourcesManager.getTime().getWaveTime());
                break;
            case "life":
                System.out.println("Life: " + resourcesManager.getLife().getValue());
                break;
            case "map":
                String data = "";
                System.out.println(data);
                break;
            case "score":
                System.out.println("Score: ");
                break;
        }
    }

    @Override
    public String toString() {
        return "[GameObject]interactions.commands.Interact: name[" + super.getName() + "] description[" + super.getDescription() + "] para[" + super.getCurrentParameter() + "]";
    }

    @Override
    public void helpInfo() {
        System.out.println("This command displays a resource to the player, depending on its parameter."
                + "\nshow <arg>");
    }
}
