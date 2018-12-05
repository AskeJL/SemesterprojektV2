package domain;

import java.util.ArrayList;
import java.util.List;

public class Controller implements Manager {

    private ControlGroup controlGroup;
    
    protected List<GameElement> elements = new ArrayList<>();

    public Controller() {
        
    }
    
    public Controller(List<GameElement> elements) {
        this.elements = elements;
    }

    @Override
    public void init(ControlGroup controlGroup) {
        this.controlGroup = controlGroup;
        for (GameElement e : elements) {
            if (e instanceof GameUpdateable) {
                ((GameUpdateable) e).init();
            }
        }
    }
    
    @Override
    public void init() {
        for (GameElement e : elements) {
            if (e instanceof GameUpdateable) {
                ((GameUpdateable) e).init();
            }
        }
    }

    @Override
    public void update() {
        for (GameElement e : elements) {
            if (e instanceof GameUpdateable) {
                ((GameUpdateable) e).update();
            }
        }
    }
    
    public Controller getController(Class className) {
        return controlGroup.fetchController(className);
    }
    
    protected void setElements(List<GameElement> elements) {
        this.elements = elements;
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
