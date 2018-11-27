package domain.locations.gameobjects;

import domain.interactions.InteractionsController;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.systems.SystemsController;

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
    public void interact(InteractionsController controller) {
        controller.println("You interact with the scanningstation\nThere are:\n"
                + "    " + SystemsController.getSmallFragments() + " small fragments.\n"
                + "    " + SystemsController.getMediumFragments() + " medium fragments.\n"
                + "    " + SystemsController.getLargeFragments() + " large fragments.\n");
    }

    @Override
    public String toString() {
        return super.getName() + super.getDescription();
    }
}
