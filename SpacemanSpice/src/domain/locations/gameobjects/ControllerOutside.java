package domain.locations.gameobjects;

import domain.DomainReader;
import domain.DomainRequester;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
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
    private final DomainRequester requester = new DomainRequester();
    
    public DamageRepair(ResourcesManager resources) {
        super("Damage repair", "Here you can repair some of the ships damage", GameObjectType.CONTROL, null);
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
        requester.playRepairSound();
        reader.storeln("You begin repairing the ship.");
        Life life = resourcesManager.getLife();
        life.setRepair(true);
    }

    @Override
    public String toString() {
        return super.getName() + super.getDescription();
    }
}
