package domain.locations.gameobjects;

import domain.DomainReader;
import domain.systems.SystemsManager;

/**
 * Used to scan the vicinity of the ship for fragments.
 * <p>
 * This {@link GameObject} is of the {@link GameObjectType#CONTROL} type.
 *
 * @see GameObject
 * @see domain.locations.functional.Scanning
 */
public class ScanningControl extends GameObject {

    private final SystemsManager systemsManager;
    private final DomainReader reader = new DomainReader();
    
    public ScanningControl(SystemsManager systems) {
        super("Scanning control");
        this.systemsManager = systems;
    }

    /**
     * Inform the player about the current amount of fragments. (small, medium
     * and large)
     *
     * @see domain.systems.Wave
     * @see domain.systems.SystemsController
     */
    @Override
    public void interact() {
        reader.storeln("You interact with the scanning station.");
        reader.storeln("You interact with the scanningstation\nThere are:\n"
                + "    " + systemsManager.getSmallFragments() + " small fragments.\n"
                + "    " + systemsManager.getMediumFragments() + " medium fragments.\n"
                + "    " + systemsManager.getLargeFragments() + " large fragments.\n");
    }
}
