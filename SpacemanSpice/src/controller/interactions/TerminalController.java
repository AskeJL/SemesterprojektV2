package controller.interactions;

import controller.game.Controller;
import controller.locations.LocationsController;
import java.util.List;

public class TerminalController extends Controller {

    private TerminalController(){}
    
    public static void init() {
        LocationsController.init();
        Commands.init();
    }

    public static void update() {
        Command command = Parser.getCommand();
        if (command != null) {
            command.run();
        }
    }
    
    public static void setRunning(boolean running){
        
        Controller.setRunning(running);
    }

    public static List<Command> getCommandWords() {
        return Commands.getCommandwords();
    }
}
