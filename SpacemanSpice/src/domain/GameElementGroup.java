package domain;

import java.util.ArrayList;
import java.util.List;

public class GameElementGroup {
    
    private ManagerGroup managerGroup;
    private Manager manager;
    
    private final List<GameElement> elements = new ArrayList<>();
    
    public void add(GameElement element) {
        element.setGameElementGroup(this);
        this.elements.add(element);
    }
    
    public void setManagerGroup(ManagerGroup group) {
        this.managerGroup = group;
    }
    
    public void setManager(Manager manager) {
        this.manager = manager;
    }
    
    public ManagerGroup getManagerGroup() {
        return this.managerGroup;
    }
    
    public Manager getManager() {
        return this.manager;
    }
    
    public GameElement getGameElement(Class element) {
        for(GameElement e : elements) {
            if(e.getClass().getCanonicalName().equals(element.getCanonicalName())) {
                return e;
            }
        }
        System.out.println("Couldn't find " + element + " in " + this.getClass().getCanonicalName());
        return null;
    }
    
    public List<GameElement> getElements() {
        return this.elements;
    }
    
    @Override
    public String toString() {
        String info = "domain.GameElementGroup\n";
        for(GameElement element : this.elements) {
            info += "  " + element + "\n";
        }
        return info;
    }
}
