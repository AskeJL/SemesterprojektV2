package domain;

import java.util.List;

public class ManagerGroup {
    private final List<Manager> controllers;
    
    public ManagerGroup(List<Manager> controllers) {
        this.controllers = controllers;
    }
    
    public Manager fetchController(Class controller) {
        for(Manager c : controllers) {
            if(c.getClass().getCanonicalName().equals(controller.getCanonicalName())) {
                return c;
            }
        }
        System.out.println("Couldn't find " + controller + " in " + this.getClass().getCanonicalName());
        return null;
    }
    
    public void add(Manager controller) {
        this.controllers.add(controller);
    }
    
    public List<Manager> getControllers() {
        return this.controllers;
    }
}
