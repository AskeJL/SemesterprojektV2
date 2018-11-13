package controller.locations.gameobjects;

import controller.locations.GameObject;
import controller.locations.GameObjectType;
import controller.systems.SystemsController;

public class NetControl extends GameObject {

    public NetControl() {
        super("Net Control", "The net is controlled from here.", GameObjectType.CONTROL);
    }
    
    @Override
    public void interact() {
        System.out.println("Interacting with net control.");
        if(SystemsController.getMediumFragments() != 0){
        controller.systems.SystemsController.setMediumFragmentDestroyed(true);
        System.out.println("You caught a medium fragment");
        }
    }

    @Override
    public String toString() {
        return "GameObject.NetControl:[" + super.getName() + "] [" + super.getDescription() + "]";
    }
    
}
