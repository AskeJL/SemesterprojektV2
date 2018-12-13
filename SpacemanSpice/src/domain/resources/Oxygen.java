package domain.resources;

import domain.GameElement;
import domain.GameElementGroup;
import domain.GameUpdateable;
import domain.locations.LocationsManager;

public class Oxygen extends GameElement implements ResourcesElement, GameUpdateable {

    /**
     * Amount of oxygen the player currently has.
     */
    private int oxygen;

    
    private final String NO_OXYGEN_LOCATION = "outside";
    /**
     * Holds the last time the oxygen was computed. Used for calculation between
     * updates.
     */
    private long lastTime;

    private LocationsManager locationsManager;
    private ResourcesManager resourcesManager;
    
    private Time time;
    private Life life;

    private boolean oxygenGenerator1On;
    private boolean oxygenGenerator2On;
    private boolean oxygenGenerator3On;
    
    public Oxygen() {
        
    }

    @Override
    public void init() {
        GameElementGroup group = this.getGameElementGroup();

        this.resourcesManager = (ResourcesManager) group.getManagerGroup().getManager(ResourcesManager.class);
        this.locationsManager = (LocationsManager)group.getManagerGroup().getManager(LocationsManager.class);
        
        time = resourcesManager.getTime();
        life = resourcesManager.getLife();
        
        setOxygenGenerator1On(false);
        setOxygenGenerator2On(false);
        setOxygenGenerator3On(false);
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

    public boolean isOxygenGenerator1On() {
        return oxygenGenerator1On;
    }

    public boolean isOxygenGenerator2On() {
        return oxygenGenerator2On;
    }

    public boolean isOxygenGenerator3On() {
        return oxygenGenerator3On;
    }

    public void setOxygenGenerator1On(boolean oxygenGenerator1On) {
        this.oxygenGenerator1On = oxygenGenerator1On;
    }

    public void setOxygenGenerator2On(boolean oxygenGenerator2On) {
        this.oxygenGenerator2On = oxygenGenerator2On;
    }

    public void setOxygenGenerator3On(boolean oxygenGenerator3On) {
        this.oxygenGenerator3On = oxygenGenerator3On;
    }
}
