package controller.locations.gameobjects;

import controller.locations.GameObject;
import controller.locations.GameObjectType;

public class LaserControl extends GameObject {

    public LaserControl() {
        super("Laser Control", "The laser is operated from here.", GameObjectType.CONTROL);
    }
    
    @Override
    public void interact() {
        System.out.println("Interacting with laser control");
        controller.systems.SystemsController.setSmallFragmentDestroyed(true);
    }

    @Override
    public String toString() {
        return "GameObject.LaserControl:[" + super.getName() + "] [" + super.getDescription() + "]";
    }
}
