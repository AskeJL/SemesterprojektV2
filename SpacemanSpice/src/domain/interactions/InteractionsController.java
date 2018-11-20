package domain.interactions;

import domain.game.Controller;
import domain.locations.LocationsController;
import java.util.List;

/**
 * The main controller of the domain.interactions package. This will manage the
 * interaction with the system. (Mostly through terminal)
 *
 * @see Command
 * @see Commands
 * @see Parser
 */
public class InteractionsController extends Controller {

    private InteractionsController() {
    }

    /**
     * Initialize the {@link domain.game.Controller controller}. Will initialize
     * needed classes.
     */
    public static void init() {
        LocationsController.init();
        Commands.init();
    }

    /**
     * Update the {@link domain.game.Controller controller}. Will wait for input
     * from the user.
     */
    public static void update() {
        // Nothing to update
    }

    public static void runCommand(String input) {
        Command command = Parser.getCommand(input);
        
        if(command != null) {
            command.run();
        }
    }
    
    /**
     * Set the running of the {@link domain.game.Game Game}. Will shutdown the
     * game if turned to false.
     *
     * @param running
     */
    public static void setRunning(boolean running) {
        Controller.setRunning(running);
    }

    /**
     * Gets the {@link Commands#COMMAND_WORDS commandwords} from the
     * {@link Commands} class using the {@link Commands#getCommandwords()}
     * method.
     *
     * @return
     */
    public static List<Command> getCommandWords() {
        return Commands.getCommandwords();
    }

    /**
     * Gets the {@link Command} from the {@link Commands} class using the
     * {@link Commands#getCommand(String)} method.
     *
     * @param name Name of the command.
     * @return
     */
    public static Command getCommand(String name) {
        return Commands.getCommand(name);
    }

    /**
     * Gets the {@link Commands#lastCommand} from the {@link Commands} class
     * using the {@link Commands#getLastCommandName()} method.
     *
     * @return
     */
    public static String getLastCommandName() {
        return Commands.getLastCommandName();
    }

    /**
     * Gets the {@link Commands#lastParameter commandwords} from the
     * {@link Commands} class using the {@link Commands#getLastParameter() }
     * method.
     *
     * @return
     */
    public static String getLastParameter() {
        return Commands.getLastParameter();
    }
}
