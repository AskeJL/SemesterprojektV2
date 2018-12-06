package domain.resources;

import domain.Controller;
import domain.GameElement;
import domain.GameUpdateable;
import java.util.List;

public class ResourcesManager extends Controller implements GameUpdateable {
    
    private Time time;
    private Life life;
    private Oxygen oxygen;
    
    public ResourcesManager() {
        
    }
    
    public ResourcesManager(List<GameElement> elements) {
        super(elements);
    }
    
    @Override
    public void init() {
        time = (Time)super.getGameElement(Time.class);
        life = (Life)super.getGameElement(Life.class);
        oxygen = (Oxygen)super.getGameElement(Oxygen.class);
        
        super.init();
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
        return "[Manager]systems.SystemsManager";
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

    public void setOxygen(int oxygen) {
        this.oxygen.setOxygen(oxygen);
    }

    public void setLife(int life) {
        this.life.setLife(life);
    }
    
    public void setDifficultyEasy(){
        life.setDifficultyEasy();
    }
    
    public void setDifficultyHard(){
        life.setDifficultyHard();
    }
}
