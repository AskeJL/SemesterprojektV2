package domain.resources;

import domain.GameElementGroup;
import domain.Manager;
import domain.GameUpdateable;

public class ResourcesManager extends Manager implements GameUpdateable {
    
    // Instances of resourceses
    private Time time;
    private Life life;
    private Oxygen oxygen;

    public ResourcesManager() {
    }
    
    /**
     * Inits resources {@link #gameElementGroup}
     * Calls super.init
     */
    @Override
    public void init() {
        GameElementGroup group = this.getGameElementGroup();

        time = (Time) group.getGameElement(Time.class);
        life = (Life) group.getGameElement(Life.class);
        oxygen = (Oxygen) group.getGameElement(Oxygen.class);
        
        super.init();
    }
    
    /**
     * Updates all resources
     * 
     * @see domain.resources.Time#update()
     * @see domain.resources.Life#update()
     * @see domain.resources.Oxygen#update() 
     */
    @Override
    public void update() {
        super.update();

        time.update();
        life.update();
        oxygen.update();
    }
    
    @Override
    public String toString() {
        String info = "domain.resources.ResourcesManager";
        info += super.toString();
        return info;
    }
    
    /**
     * Get {@link #time time}
     * 
     * @return time
     */
    public Time getTime() {
        return this.time;
    }
    
    /**
     * Get {@link #life life}
     * 
     * @return life
     */
    public Life getLife() {
        return this.life;
    }
    
    /**
     * Get {@link #oxygen oxygen}
     * 
     * @return oxygen
     */
    public Oxygen getOxygen() {
        return this.oxygen;
    }
}
