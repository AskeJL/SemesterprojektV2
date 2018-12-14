package domain.locations.gameobjects;

import domain.DomainReader;
import domain.locations.ExitDirection;
import domain.locations.GameObject;
import domain.locations.GameObjectType;

public class ExitEast extends GameObject {

    private final DomainReader reader = new DomainReader();

    public ExitEast() {
        super("East exit", "You can go east from here.", GameObjectType.EAST, ExitDirection.EAST);
    }

    @Override
    public void interact() {
        
    }

}
