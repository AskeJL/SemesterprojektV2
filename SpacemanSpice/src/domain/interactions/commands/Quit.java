package domain.interactions.commands;

import domain.DomainReader;
import domain.interactions.Command;

/**
 * This command is responsible for quitting the game when prompted. Calls the
 * {@link InteractionsController#setRunning(boolean)} method.
 *
 * @see domain.game.Controller
 * @see domain.game.Game
 */
public class Quit extends Command {

    private final DomainReader reader = new DomainReader();
    
    public Quit() {
        super("quit", "Quit the game.", false);        
    }

    @Override
    public void checkAvailableParameters() {
        // Nothing to check
    }

    /**
     * Sets the {@link InteractionsController#setRunning(boolean)} to false.
     * Shutting down the game. Will print a goodbye message before shutting
     * down.
     */
    @Override
    public void run() {
        reader.storeln("You are now exiting the game - thank you for playing!"
                + "\nGoodbye...");
        System.exit(0);
    }

    @Override
    public String toString() {
        return "domain.interactions.commands.Quit: name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

    @Override
    public void helpInfo() {
        reader.storeln("The quit function lets you quit the game");
    }
}
