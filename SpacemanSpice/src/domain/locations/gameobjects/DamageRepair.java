package domain.locations.gameobjects;

import domain.DomainReader;
import domain.resources.Life;
import domain.resources.ResourcesManager;

/**
 * Used to repair the hull of the ship.
 * <p>
 * This {@link GameObject} is of the {@link GameObjectType#CONTROL} type.
 *
 * @see GameObject
 * @see domain.locations.functional.Outside
 */
public class DamageRepair extends GameObject {
    
    private final ResourcesManager resourcesManager;
    private final DomainReader reader = new DomainReader();
    
    public DamageRepair(ResourcesManager resources) {
        super("Damage repair");
        this.resourcesManager = resources;
    }

    /**
     * Repair some of the ship. This will set the
     * {@link domain.resources.ResourcesController#setRepairTrue()} boolean.
     *
     * @see domain.resources.ResourcesController
     * @see domain.resources.Life
     */
    @Override
    public void interact() {
        reader.storeln("You begin reparing the ship");
        Life life = resourcesManager.getLife();
        life.increaseValue(100);
    }
}
