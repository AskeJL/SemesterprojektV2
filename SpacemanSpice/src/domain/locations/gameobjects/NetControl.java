package domain.locations.gameobjects;

import domain.DomainReader;
import domain.systems.SystemsManager;

/**
 * Used to catch medium fragments.
 * <p>
 * This {@link GameObject} is of the {@link GameObjectType#CONTROL} type.
 *
 * @see GameObject
 * @see domain.locations.functional.Net
 */
public class NetControl extends GameObject {

    private final SystemsManager systemsManager;
    private final DomainReader reader = new DomainReader();
    
    public NetControl(SystemsManager systems) {
        super("Net control");
        this.systemsManager = systems;
    }

    /**
     * Catch a medium fragment. This will set the
     * {@link domain.systems.SystemsController#setMediumFragmentDestroyed(boolean)}
     * boolean.
     * <p>
     * Only runs if there are any medium fragments to destroy.
     *
     * @see domain.systems.Wave
     * @see domain.systems.SystemsController
     */
    @Override
    public void interact() {
        reader.storeln("Interacting with net control.");
        systemsManager.setMediumFragmentDestroyed(true);
    }
}
