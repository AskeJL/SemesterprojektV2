package domain.locations.gameobjects;

import domain.interactions.InteractionsController;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.locations.LocationsController;
import domain.resources.ResourcesController;

/**
 * Used to repair the hull of the ship.
 * <p>
 * This {@link GameObject} is of the {@link GameObjectType#CONTROL} type.
 *
 * @see GameObject
 * @see domain.locations.functional.Outside
 */
public class DamageRepair extends GameObject {

    private final ResourcesController resourcesController;
    
    public DamageRepair() {
        super("Damage repair", "Here you can repair some of the ships damage", GameObjectType.CONTROL);
        
        this.resourcesController = locationsController.getResourcesController();
    }

    /**
     * Repair some of the ship. This will set the
     * {@link domain.resources.ResourcesController#setRepairTrue()} boolean.
     *
     * @see domain.resources.ResourcesController
     * @see domain.resources.Life
     */
    @Override
    public void interact(InteractionsController controller) {
        output.println("You begin reparing the ship");
        
        resourcesController.setRepairTrue();
    }

    @Override
    public String toString() {
        return super.getName() + super.getDescription();
    }
}
