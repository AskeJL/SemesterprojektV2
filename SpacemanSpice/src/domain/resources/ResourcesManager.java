package domain.resources;

import domain.GameElementGroup;
import domain.Manager;
import domain.GameUpdateable;

public class ResourcesManager extends Manager implements GameUpdateable {

    private Time time;
    private Life life;
    private Oxygen oxygen;

    public ResourcesManager() {

    }

    @Override
    public void init() {
        GameElementGroup group = this.getGameElementGroup();

        time = (Time) group.getGameElement(Time.class);
        life = (Life) group.getGameElement(Life.class);
        oxygen = (Oxygen) group.getGameElement(Oxygen.class);
    }

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

    public Time getTime() {
        return this.time;
    }

    public Life getLife() {
        return this.life;
    }

    public Oxygen getOxygen() {
        return this.oxygen;
    }
}
