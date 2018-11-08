package controller.locations.gameobjects;

import controller.locations.GameObject;
import controller.locations.GameObjectType;

public class LaserControl extends GameObject {

    public LaserControl() {
        super("Laser Control", "The laser is operated from here.", GameObjectType.CONTROL);
    }
    
    @Override
    public void interact() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
