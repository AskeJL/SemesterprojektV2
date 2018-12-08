package domain.interactions.commands;

import domain.DomainReader;
import domain.interactions.Command;
import domain.locations.LocationsManager;

/**
 * This command is responsible for interacting with {@link GameObject}'s in the
 * current room.
 *
 * @see domain.locations.GameObject
 * @see domain.locations.GameObjectType
 */
public class Interact extends Command {
    
    private final LocationsManager locationsManager;
    private final DomainReader reader = new DomainReader();
    
    public Interact(LocationsManager locations){
        super("interact", "Interact with an object.", false);
        
        this.locationsManager = locations;
    }

    @Override
    protected void checkAvailableParameters() {
        // Nothing to check
    }

    /**
     * Gets the first {@link GameObject} in the room and calls its
     * {@link GameObject#interact() interact()} method.
     */
    @Override
    protected void run() {
        if (!locationsManager.getCurrentRoom().getGameObjects().isEmpty()) {
            locationsManager.getCurrentRoom().getGameObjects().get(0).interact();
        } else {
            reader.storeln("There are nothing to interact with in this room");
        }
    }

    @Override
    public String toString() {
        return "domain.interactions.commands.Interact: name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

    @Override
    public void helpInfo() {
        reader.storeln("The interact command lets you interact with objects in the current room.");
    }
}
