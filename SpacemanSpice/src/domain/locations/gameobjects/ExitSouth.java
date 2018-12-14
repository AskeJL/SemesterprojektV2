package domain.locations.gameobjects;

import domain.DomainReader;
import domain.locations.ExitDirection;
import domain.locations.GameObject;
import domain.locations.GameObjectType;

public class ExitSouth extends GameObject{

    private final DomainReader reader = new DomainReader();
    
    public ExitSouth(){
        super("South exit", "You can go south from here.", GameObjectType.SOUTH, ExitDirection.SOUTH);
    }
    
    @Override
    public void interact() {
       
    }
}
