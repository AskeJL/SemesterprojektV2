package domain.game;

import java.util.ArrayList;
import java.util.List;

public abstract class Controller {
    private static List<Controller> CONTROLLERS = new ArrayList<>();
    
    /**
     * For initializing the controller. All the classes that needs to be
     * initialized is initialized here.
     */
    public abstract void init();

    /**
     * An update that is continously called from Game.
     */
    public abstract void update();
    
    static void setControllers(List<Controller> controllers) {
        CONTROLLERS = controllers;
    }
    
    public <T extends Controller> Controller getController(T t) {
        for (Controller c : CONTROLLERS) {
            if (t.equals(c)) {
                return c;
            }
        }
        
        return null;
    }
    
    public List<Controller> getControllers() {
        return CONTROLLERS;
    }
}
