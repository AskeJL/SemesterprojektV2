package domain.resources;

import domain.GameUpdateable;
import domain.locations.LocationsManager;

public class Oxygen implements ResourcesElement, GameUpdateable {

    /**
     * Amount of oxygen the player currently has.
     */
    private int oxygen = 10;

    
    private final String NO_OXYGEN_LOCATION = "outside";
    /**
     * Holds the last time the oxygen was computed. Used for calculation between
     * updates.
     */
    private long lastTime;

    private final LocationsManager locationsManager;
    private final ResourcesManager resourcesManager;
    
    private Time time;
    private Life life;

    public Oxygen(ResourcesManager resources, LocationsManager locations) {
        this.resourcesManager = resources;
        this.locationsManager = locations;
    }

    @Override
    public void init() {
        time = resourcesManager.getTime();
        life = resourcesManager.getLife();
    }
    
    /**
     * Will decrease oxygen if {@link Life#life} is below 50. Oxygen will also
     * decrease if the player is currently standing in a place without oxygen.
     *
     * @see domain.locations.functional.Outside
     * @see domain.locations.functional.Oxygen
     */
    @Override
    public void update() {
        if (life.getValue() <= 50) {
            oxygen -= (time.getCurrentTime() - lastTime);
        } 
        else if (locationsManager.getCurrentRoom() != null && locationsManager.getCurrentRoom().getName().equalsIgnoreCase(this.NO_OXYGEN_LOCATION)){
            oxygen -= (time.getCurrentTime() - lastTime);
            
        }
        else if(locationsManager.getCurrentLocation() != null && locationsManager.getCurrentLocation().getName().equalsIgnoreCase(this.NO_OXYGEN_LOCATION)) {
            oxygen -= (time.getCurrentTime() - lastTime);
        }

        lastTime = time.getCurrentTime();
    }

    @Override
    public void decreaseValue(int value) {
        this.oxygen -= value;
    }

    /**
     * Increase {@link #oxygen oxygen}.
     *
     * @param value How much to increase.
     */
    @Override
    public void increaseValue(int value) {
        this.oxygen += value;
    }
    
    @Override
    public void setValue(int oxygen){
        this.oxygen = oxygen;
    }

    /**
     * Get {@link #oxygen oxygen}.
     *
     * @return
     */
    @Override
    public int getValue() {
        return this.oxygen;
    }
}
