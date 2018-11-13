package domain.locations.gameobjects;

import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.systems.SystemsController;

/**
 * Net control game object
 */
public class NetControl extends GameObject {

    public NetControl() {
        super("Net Control", "The net is controlled from here.", GameObjectType.CONTROL);
    }
    
    @Override
    public void interact() {
        System.out.println("Interacting with net control.");
        if(SystemsController.getMediumFragments() != 0){
            domain.systems.SystemsController.setMediumFragmentDestroyed(true);
        System.out.println("You caught a medium fragment");
        }
    }

    @Override
    public String toString() {
        return "GameObject.NetControl:[" + super.getName() + "] [" + super.getDescription() + "]";
    }
    
}
