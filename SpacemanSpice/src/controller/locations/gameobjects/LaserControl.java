package controller.locations.gameobjects;

import controller.locations.GameObject;
import controller.locations.GameObjectType;
import controller.systems.SystemsController;

/**
 * Laser control game object
 */
public class LaserControl extends GameObject {

    public LaserControl() {
        super("Laser Control", "The laser is operated from here.", GameObjectType.CONTROL);
    }
    
    @Override
    public void interact() {
        System.out.println("Interacting with laser control");
        if(SystemsController.getSmallFragments() != 0){
        controller.systems.SystemsController.setSmallFragmentDestroyed(true);
        System.out.println("You have destroyed a small fragment");
        }
    }

    @Override
    public String toString() {
        return "GameObject.LaserControl:[" + super.getName() + "] [" + super.getDescription() + "]";
    }
}
