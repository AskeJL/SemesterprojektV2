package domain.locations;

import domain.game.DomainOutput;
import domain.interactions.InteractionsController;

public class LocationsElement {

    protected LocationsController locationsController;
    protected final DomainOutput output = new DomainOutput();

    void init(InteractionsController interact, LocationsController location) {
        this.locationsController = location;
    }
}
