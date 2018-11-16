package domain.locations.gameobjects;

import domain.locations.GameObject;
import domain.locations.GameObjectType;

/**
 * Used to scan the vicinity of the ship for fragments.
 * <br><br>
 * This {@link GameObject} is of the {@link GameObjectType#CONTROL} type.
 *
 * @see GameObject
 * @see domain.locations.functional.Scanning
 */
public class ScanningControl extends GameObject {

    public ScanningControl() {
        super("Scanning control", "This is the scanningstation", GameObjectType.CONTROL);
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
        System.out.println("You interact with the scanningstation\nThere are:");
        System.out.format("%10s %1s\n", "", domain.systems.SystemsController.getSmallFragments() + " small fragments.");
        System.out.format("%10s %1s\n", "", domain.systems.SystemsController.getMediumFragments() + " medium fragments.");
        System.out.format("%10s %1s\n", "", domain.systems.SystemsController.getLargeFragments() + " large fragments.");
    }

    @Override
    public String toString() {
        return super.getName() + super.getDescription();
    }
}
