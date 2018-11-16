package domain.locations.gameobjects;

import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.systems.SystemsController;

/**
 * Used to destroy small fragments.
 * <br><br>
 * This {@link GameObject} is of the {@link GameObjectType#CONTROL} type.
 *
 * @see GameObject
 * @see domain.locations.functional.Laser
 */
public class LaserControl extends GameObject {

    public LaserControl() {
        super("Laser Control", "The laser is operated from here.", GameObjectType.CONTROL);
    }

    /**
     * Destroy a small fragment. This will set the
     * {@link domain.systems.SystemsController#setSmallFragmentDestroyed(boolean)}
     * boolean.
     * <br><br>
     * Only runs if there are any small fragments to destroy.
     *
     * @see domain.systems.Wave
     * @see domain.systems.SystemsController
     */
    @Override
    public void interact() {
        System.out.println("Interacting with laser control");
        if (SystemsController.getSmallFragments() != 0) {
            domain.systems.SystemsController.setSmallFragmentDestroyed(true);
        }
    }

    @Override
    public String toString() {
        return "GameObject.LaserControl:[" + super.getName() + "] [" + super.getDescription() + "]";
    }
}
