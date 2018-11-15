package domain.interactions;

import domain.game.Controller;
import domain.locations.LocationsController;
import java.util.List;

public class InteractionsController extends Controller {

    private InteractionsController(){}
    
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
    
    public static Command getCommand(String name) {
        return Commands.getCommand(name);
    }
    
    public static String getLastCommandName() {
        return Commands.getLastCommandName();
    }
    
    public static String getLastParameter() {
        return Commands.getLastParameter();
    }
}
