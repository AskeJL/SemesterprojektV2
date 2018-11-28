package domain.systems;

import domain.game.DomainOutput;
import domain.interactions.InteractionsController;
import domain.locations.LocationsController;

public class SystemsElement {

    protected LocationsController locationsController;
    protected final DomainOutput output = new DomainOutput();

    void init(InteractionsController interact, LocationsController location) {
        this.locationsController = location;
    }
}
