package domain.locations.gameobjects;

import domain.interactions.InteractionsController;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.resources.ResourcesController;

/**
 * Used to fill up the players oxygen.
 * <br><br>
 * This {@link GameObject} is of the {@link GameObjectType#CONTROL} type.
 *
 * @see GameObject
 * @see domain.locations.functional.Oxygen
 */
public class OxygenControl extends GameObject {

    private final ResourcesController resourcesController;
    
    public OxygenControl() {
        super("Oxygen control", "This is the refilling station for oxygen", GameObjectType.CONTROL);
        
        this.resourcesController = locationsController.getResourcesController();
    }

    /**
     * Refills the players {@link domain.resources.Oxygen}. This will call the
     * {@link ResourcesController#increaseOxygen(int)}
     * <p>
     * This will always fill the {@link domain.resources.Oxygen} completely.
     *
     * @see domain.resources.Oxygen
     * @see domain.resources.ResourcesController
     */
    @Override
    public void interact(InteractionsController controller) {
        output.println("You interact with the Oxygen refilling control");
        int difference = 100 - resourcesController.getOxygenValue();
        resourcesController.increaseOxygen(difference);
    }

    @Override
    public String toString() {
        return super.getName() + super.getDescription();
    }

}
