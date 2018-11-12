package controller.locations.gameobjects;

import controller.locations.GameObject;
import controller.locations.GameObjectType;

public class NetControl extends GameObject {

    public NetControl() {
        super("Net Control", "The net is controlled from here.", GameObjectType.CONTROL);
    }
    
    @Override
    public void interact() {
        System.out.println("Interacting with net control.");
        controller.systems.SystemsController.setMediumFragmentDestroyed(true);
        System.out.println("You caught a medium fragment");
        System.out.println("There are now "+controller.systems.SystemsController.getMediumFragments()+" left");
    }

    @Override
    public String toString() {
        return "GameObject.NetControl:[" + super.getName() + "] [" + super.getDescription() + "]";
    }
    
}
