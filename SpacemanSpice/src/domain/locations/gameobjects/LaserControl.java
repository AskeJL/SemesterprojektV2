package domain.locations.gameobjects;

import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.systems.SystemsController;

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
            domain.systems.SystemsController.setSmallFragmentDestroyed(true);
        System.out.println("You have destroyed a small fragment");
        }
    }

    @Override
    public String toString() {
        return "GameObject.LaserControl:[" + super.getName() + "] [" + super.getDescription() + "]";
    }
}
