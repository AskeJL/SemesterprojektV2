package domain.game;

public abstract class Controller {
    
    private final Game game;
    
    public Controller(Game game) {
        this.game = game;
    }
    
    /**
     * For initializing the controller. All the classes that needs to be
     * initialized is initialized here.
     */
    public abstract void init();

    /**
     * An update that is continously called from Game.
     */
    public abstract void update();
    
    public <T extends Controller> Controller getController(T t) {
        for (Controller c : game.getControllers()) {
            if (t.equals(c)) {
                return c;
            }
        }
        
        return null;
    }
}
