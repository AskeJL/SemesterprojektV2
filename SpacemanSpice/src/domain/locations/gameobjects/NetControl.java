package domain.locations.gameobjects;

import domain.interactions.InteractionsController;
import domain.locations.GameObject;
import domain.locations.GameObjectType;

/**
 * Used to catch medium fragments.
 * <br><br>
 * This {@link GameObject} is of the {@link GameObjectType#CONTROL} type.
 *
 * @see GameObject
 * @see domain.locations.functional.Net
 */
public class NetControl extends GameObject {

    public NetControl() {
        super("Net Control", "The net is controlled from here.", GameObjectType.CONTROL);
    }

    /**
     * Catch a medium fragment. This will set the
     * {@link domain.systems.SystemsController#setMediumFragmentDestroyed(boolean)}
     * boolean.
     * <br><br>
     * Only runs if there are any medium fragments to destroy.
     *
     * @see domain.systems.Wave
     * @see domain.systems.SystemsController
     */
    @Override
    public void interact(InteractionsController controller) {
        controller.println("Interacting with net control.");
        domain.systems.SystemsController.setMediumFragmentDestroyed(true);
    }

    @Override
    public String toString() {
        return "GameObject.NetControl:[" + super.getName() + "] [" + super.getDescription() + "]";
    }

}
