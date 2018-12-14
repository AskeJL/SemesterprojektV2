package domain.interactions.commands;

import domain.DomainReader;
import domain.interactions.Command;
import domain.resources.ResourcesManager;
import domain.systems.SystemsManager;

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
    private final DomainReader reader = new DomainReader();
    
    public Show(ResourcesManager resources) {
        super("show", "Shows a resource to the player.", true);

        super.addParameter("oxygen");
        super.addParameter("time");
        super.addParameter("life");
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
        SystemsManager systems = (SystemsManager) resourcesManager.getManager(SystemsManager.class);
        
        switch (super.getCurrentParameter()) {
            case "oxygen":
                reader.storeln("Oxygen: " + resourcesManager.getOxygen().getValue());
                break;
            case "time":
                reader.storeln("Time: " + resourcesManager.getTime().getWaveTime());
                break;
            case "life":
                reader.storeln("Life: " + resourcesManager.getLife().getValue());
                break;
            case "score":
                reader.storeln("Score: " + systems.getScore());
                break;
        }
    }

    @Override
    public String toString() {
        return "[GameObject]interactions.commands.Interact: name[" + super.getName() + "] description[" + super.getDescription() + "] para[" + super.getCurrentParameter() + "]";
    }

    @Override
    public void helpInfo() {
        reader.storeln("This command displays a resource to the player, depending on its parameter."
                + "\nshow <arg>");
    }
}
