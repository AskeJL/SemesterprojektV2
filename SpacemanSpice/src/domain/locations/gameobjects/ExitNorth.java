package domain.locations.gameobjects;

import domain.DomainReader;
import domain.locations.ExitDirection;
import domain.locations.GameObject;
import domain.locations.GameObjectType;

public class ExitNorth extends GameObject {

    private final DomainReader reader = new DomainReader();

    public ExitNorth() {
        super("North exit", "You can go north from here.", GameObjectType.NORTH, ExitDirection.NORTH);
    }

    @Override
    public void interact() {
        reader.storeln("Interacting with north door.");
    }

}
