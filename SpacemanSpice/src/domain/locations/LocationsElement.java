package domain.locations;

import domain.game.DomainOutput;

public class LocationsElement {
    protected final DomainOutput output = new DomainOutput();
    protected static LocationsController locationsController;
    
    void init(LocationsController controller) {
        LocationsElement.locationsController = controller;
    }
}
