package domain.interactions.commands;

import domain.interactions.Command;
import domain.locations.GameObject;
import domain.locations.LocationsController;

/**
 * This command is responsible for interacting with {@link GameObject}'s in the
 * current room.
 *
 * @see domain.locations.GameObject
 * @see domain.locations.GameObjectType
 */
public class Interact extends Command {
    
    private final LocationsController locationsController;
    
    public Interact(LocationsController locations){
        super("interact", "Interact with an object.", false);
        this.locationsController = locations;
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
        if (locationsController.getCurrentRoom().getGameObjects().isEmpty() == false) {
            locationsController.getCurrentRoom().getGameObjects().get(0).interact();
        } else {
            output.println("There are nothing to interact with in this room");
        }
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Interact: name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

    @Override
    public void helpInfo() {
        output.println("The interact command lets you interact with objects in the current room.");
    }
}
