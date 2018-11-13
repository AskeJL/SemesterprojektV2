package domain.locations.gameobjects;

import domain.locations.GameObject;
import domain.locations.GameObjectType;

/**
 * Damage repair game object
 */
public class DamageRepair extends GameObject {
    
    public DamageRepair(){
        super("Damage repair","Here you can repair some of the ships damage",GameObjectType.CONTROL);
    }

    @Override
    public void interact() {
        System.out.println("You begin reparing the ship");
        domain.resources.ResourcesController.setRepairTrue();
        System.out.println("Type: 'show life', to see the remaining health of the ship");
    }

    @Override
    public String toString() {
        return super.getName() + super.getDescription();
    }
    
}
