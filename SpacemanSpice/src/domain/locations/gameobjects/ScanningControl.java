package domain.locations.gameobjects;

import domain.locations.GameObject;
import domain.locations.GameObjectType;

/**
 * Scanning game object
 */
public class ScanningControl extends GameObject {
    
    public ScanningControl(){
        super("Scanning control","This is the scanningstation",GameObjectType.CONTROL);
    }

    @Override
    public void interact() {
        System.out.println("You interact with the scanningstation");
        System.out.print("There are "+ domain.systems.SystemsController.getSmallFragments() + " small fragments,");
        System.out.print(domain.systems.SystemsController.getMediumFragments() + " medium fragments and ");
        System.out.println(domain.systems.SystemsController.getLargeFragments() + " large fragments in the wave");
    }

    @Override
    public String toString() {
        return super.getName() + super.getDescription();
    }
    
}