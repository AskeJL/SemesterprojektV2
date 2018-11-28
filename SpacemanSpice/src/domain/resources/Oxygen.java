package domain.resources;

import domain.locations.LocationsController;

/**
 * This is used by other systems to compute the current amount of oxygen the
 * player has. The oxygen will vary depending on where the player is, and the
 * amount of damage the ship has taken ({@link Life}).
 *
 * @see domain.systems.Wave
 * @see domain.systems.SystemsController
 */
public class Oxygen extends ResourcesElement {

    /**
     * Amount of oxygen the player currently has.
     */
    private static int oxygen = 75;

    /**
     * Holds the last time the oxygen was computed. Used for calculation between
     * updates.
     */
    private long lastTime;

    private final LocationsController locationsController;
    
    private final Time time;
    private final Life life;
    
    Oxygen(ResourcesController resources) {
        super(resources);
        
        this.locationsController = resourcesController.getLocationsController();
        this.time = resourcesController.getTime();
        this.life = resourcesController.getLife();
    }

    /**
     * Will decrease oxygen if {@link Life#life} is below 50. Oxygen will also
     * decrease if the player is currently standing in a place without oxygen.
     *
     * @see domain.locations.functional.Outside
     * @see domain.locations.functional.Oxygen
     */
    void update() {
        if (life.getLife() <= 50) {
            oxygen -= (time.getCurrentTime() - lastTime);
        } else if(locationsController.getCurrentRoom().getName().equalsIgnoreCase("outside")) {
            oxygen -= (time.getCurrentTime() - lastTime);
        }

        lastTime = time.getCurrentTime();
    }

    /**
     * Increase {@link #oxygen oxygen}.
     *
     * @param value How much to increase.
     */
    void increaseOxygen(int value) {
        oxygen += value;
    }

    /**
     * Get {@link #oxygen oxygen}.
     *
     * @return
     */
    int getOxygen() {
        return oxygen;
    }

    @Override
    protected boolean runTest() {
        return true;
    }
}
