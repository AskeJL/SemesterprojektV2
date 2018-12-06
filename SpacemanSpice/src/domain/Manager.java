package domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Manager {

    private ManagerGroup controlGroup;
    
    protected List<GameElement> elements = new ArrayList<>();

    public Manager() {
        
    }
    
    public Manager(List<GameElement> elements) {
        this.elements = elements;
    }

    public void init(ManagerGroup controlGroup) {
        this.controlGroup = controlGroup;
        for (GameElement e : elements) {
            if (e instanceof GameUpdateable) {
                ((GameUpdateable) e).init();
            }
        }
    }
    
    public void init() {
        for (GameElement e : elements) {
            if (e instanceof GameUpdateable) {
                ((GameUpdateable) e).init();
            }
        }
    }

    public void update() {
        for (GameElement e : elements) {
            if (e instanceof GameUpdateable) {
                ((GameUpdateable) e).update();
            }
        }
    }
    
    protected void setElements(List<GameElement> elements) {
        this.elements = elements;
    }
    
    public Manager fetchController(Class className) {
        return controlGroup.fetchController(className);
    }
    
    protected GameElement getGameElement(Class element) {
        for (GameElement g : elements) {
            if (g.getClass().getCanonicalName().equals(element.getCanonicalName())) {
                return g;
            }
        }
        System.out.println("Couldn't find " + element + " in " + this.getClass() + ". Returning null.");
        return null;
    }
}
