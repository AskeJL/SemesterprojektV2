package domain;

import java.util.ArrayList;
import java.util.List;

public class Controller<T> implements Manager {

    protected List<T> elements = new ArrayList<>();

    public Controller() {
        
    }
    
    public Controller(List<T> elements) {
        this.elements = elements;
    }

    @Override
    public void init() {
        for (T e : elements) {
            if (e instanceof GameUpdateable) {
                ((GameUpdateable) e).init();
            }
        }
    }

    @Override
    public void update() {
        for (T e : elements) {
            if (e instanceof GameUpdateable) {
                ((GameUpdateable) e).update();
            }
        }
    }

    protected void setElements(List<T> elements) {
        this.elements = elements;
    }
    
    protected T getGameElement(Class element) {
        for (T g : elements) {
            if (g.getClass().getCanonicalName().equals(element.getCanonicalName())) {
                return g;
            }
        }
        System.out.println("Couldn't find " + element + " in " + this.getClass() + ". Returning null.");
        return null;
    }
}
