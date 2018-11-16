package domain.locations.gameobjects;

import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.systems.SystemsController;

/**
 * Used to dodge large fragments.
 * <br><br>
 * This {@link GameObject} is of the {@link GameObjectType#CONTROL} type.
 *
 * @see GameObject
 * @see domain.locations.functional.Laser
 */
public class SteeringControl extends GameObject {

    public SteeringControl() {
        super("Steering Control", "The ship is flown from here.", GameObjectType.CONTROL);
    }

    /**
     * Destroy a large fragment. This will set the
     * {@link domain.systems.SystemsController#setLargeFragmentDestroyed(boolean)}
     * boolean.
     * <br><br>
     * Only runs if there are any small fragments to destroy.
     *
     * @see domain.systems.Wave
     * @see domain.systems.SystemsController
     */
    @Override
    public void interact() {
        System.out.println("Interacting with the steering controls.");
        if (SystemsController.getLargeFragments() != 0) {
            domain.systems.SystemsController.setLargeFragmentDestroyed(true);
            System.out.println("You have moved the ship out of danger");
        }
    }

    @Override
    public String toString() {
        return "GameObject.SteeringControl:[" + super.getName() + "] [" + super.getDescription() + "]";
    }
}
