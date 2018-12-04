package domain;

import java.util.List;

public class ControlGroup {
    private final List<Controller> controllers;
    
    public ControlGroup(List<Controller> controllers) {
        this.controllers = controllers;
    }
    
    public Controller fetchController(Class controller) {
        for(Controller c : controllers) {
            if(c.getClass().getCanonicalName().equals(controller.getCanonicalName())) {
                return c;
            }
        }
        System.out.println("Couldn't find " + controller + " in " + this.getClass().getCanonicalName());
        return null;
    }
    
    public List<Controller> getControllers() {
        return this.controllers;
    }
}
