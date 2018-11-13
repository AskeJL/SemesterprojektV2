package controller.locations.gameobjects;

import controller.locations.GameObject;
import controller.locations.GameObjectType;
import controller.systems.SystemsController;

public class SteeringControl extends GameObject {

    public SteeringControl() {
        super("Steering Control", "The ship is flown from here.", GameObjectType.CONTROL);
    }
    
    @Override
    public void interact() {
        System.out.println("Interacting with the steering controls.");
        if(SystemsController.getLargeFragments() != 0){
        controller.systems.SystemsController.setLargeFragmentDestroyed(true);
        System.out.println("You have moved the ship out of danger");
        }
    }
        
    @Override
    public String toString() {
        return "GameObject.SteeringControl:[" + super.getName() + "] [" + super.getDescription() + "]";
    }
}
