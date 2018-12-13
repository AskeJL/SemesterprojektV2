package domain.locations.gameobjects;

import domain.DomainReader;
import domain.locations.ExitDirection;
import domain.locations.GameObject;
import domain.locations.GameObjectType;

public class ExitWest extends GameObject{

    private final DomainReader reader = new DomainReader();
    
    public ExitWest(){
        super("West exit", "You can go west from here.", GameObjectType.WEST, ExitDirection.WEST);
    }
    
    @Override
    public void interact() {
        reader.storeln("Interacting with west door.");
    }
}
