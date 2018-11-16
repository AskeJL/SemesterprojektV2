package domain.locations.gameobjects;

import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.resources.ResourcesController;

/**
 * Used to fill up the players oxygen.
 * <br><br>
 * This {@link GameObject} is of the {@link GameObjectType#CONTROL} type.
 *
 * @see GameObject
 * @see domain.locations.functional.Oxygen
 */
public class OxygenControl extends GameObject {

    public OxygenControl() {
        super("Oxygen control", "This is the refilling station for oxygen", GameObjectType.CONTROL);
    }

    /**
     * Refills the players {@link domain.resources.Oxygen}. This will call the
     * {@link ResourcesController#increaseOxygen(int)}
     * <br><br>
     * This will always fill the {@link domain.resources.Oxygen} completely.
     *
     * @see domain.resources.Oxygen
     * @see domain.resources.ResourcesController
     */
    @Override
    public void interact() {
        System.out.println("You interact with the Oxygen refilling control");
        int difference = 100 - ResourcesController.getOxygen();
        ResourcesController.increaseOxygen(difference);
    }

    @Override
    public String toString() {
        return super.getName() + super.getDescription();
    }

}
