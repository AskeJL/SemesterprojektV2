package domain.interactions.commands;

import domain.interactions.Command;
import domain.interactions.InteractionsController;
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
    
    public Interact(InteractionsController interactions){
        super(interactions, "interact", "Interact with an object.", false);
        
        locationsController = interactionsController.getLocationsController();
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
        if (!locationsController.getCurrentRoom().getGameObjects().isEmpty()) {
            locationsController.getCurrentRoom().getGameObjects().get(0).interact(interactionsController);
        } else {
            output.println("There are nothing to interact with in this room");
        }
    }

    @Override
    public String toString() {
        return "domain.interactions.commands.Interact: name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

    @Override
    public void helpInfo() {
        output.println("The interact command lets you interact with objects in the current room.");
    }

    @Override
    protected boolean runTest() {
        return locationsController == null;
    }
}
