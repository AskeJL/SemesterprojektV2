package domain.interactions;

import domain.game.Controller;
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
    
    private final Commands commands = new Commands(this);
    private final Parser parser = new Parser(this);
    
    public InteractionsController() {
        
    }
    
    /**
     * Initialize the {@link domain.game.Controller controller}. Will initialize
     * needed classes.
     */
    @Override
    public void init() {
        
    }

    /**
     * Update the {@link domain.game.Controller controller}. Will wait for input
     * from the user.
     */
    @Override
    public void update() {
        // Nothing to update
    }

    public void runCommand(String input) {
        Command command = parser.getCommand(input);

        if (command != null) {
            command.run();
        }
    }
    
    public void setLastCommand(Command command) {
        commands.setLastCommand(command);
    }

    public Commands getCommands() {
        return this.commands;
    }
    
    public Parser getParser() {
        return this.parser;
    }

    /**
     * Gets the {@link Commands#COMMAND_WORDS commandwords} from the
     * {@link Commands} class using the {@link Commands#getCommandwords()}
     * method.
     *
     * @return
     */
    public List<Command> getCommandWords() {
        return commands.getCommandwords();
    }

    /**
     * Gets the {@link Command} from the {@link Commands} class using the
     * {@link Commands#getCommand(String)} method.
     *
     * @param name Name of the command.
     * @return
     */
    public Command getCommand(String name) {
        return commands.getCommand(name);
    }

    /**
     * Gets the {@link Commands#lastCommand} from the {@link Commands} class
     * using the {@link Commands#getLastCommandName()} method.
     *
     * @return
     */
    public String getLastCommandName() {
        return commands.getLastCommandName();
    }

    /**
     * Gets the {@link Commands#lastParameter commandwords} from the
     * {@link Commands} class using the {@link Commands#getLastParameter() }
     * method.
     *
     * @return
     */
    public String getLastParameter() {
        return commands.getLastParameter();
    }
}
