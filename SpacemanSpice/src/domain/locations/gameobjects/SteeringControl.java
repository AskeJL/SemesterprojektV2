package domain.locations.gameobjects;

import domain.DomainReader;
import domain.systems.SystemsManager;

/**
 * Used to dodge large fragments.
 * <p>
 * This {@link GameObject} is of the {@link GameObjectType#CONTROL} type.
 *
 * @see GameObject
 * @see domain.locations.functional.Laser
 */
public class SteeringControl extends GameObject {

    private final SystemsManager systemsManager;
    private final DomainReader reader = new DomainReader();
    
    public SteeringControl(SystemsManager systems) {
        super("Steering control");
        this.systemsManager = systems;
    }

    /**
     * Destroy a large fragment. This will set the
     * {@link domain.systems.SystemsController#setLargeFragmentDestroyed(boolean)}
     * boolean.
     * <p>
     * Only runs if there are any small fragments to destroy.
     *
     * @see domain.systems.Wave
     * @see domain.systems.SystemsController
     */
    @Override
    public void interact() {
        reader.storeln("Interacting with the steering controls.");
        if (systemsManager.getLargeFragments() != 0) {
            systemsManager.setLargeFragmentDestroyed(true);
            reader.storeln("You have moved the ship out of danger");
        }
    }
}
