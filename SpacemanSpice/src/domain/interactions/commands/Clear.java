package domain.interactions.commands;

import domain.DomainReader;
import domain.interactions.Command;

/**
 * This command is responsible for clearing the screen when prompted.
 *
 * @see domain.interactions.Command
 * @see domain.interactions.Commands
 */
public class Clear extends Command {

    private final DomainReader reader = new DomainReader();
    
    public Clear() {
        super("clear", "Clears the terminal", false);
    }

    @Override
    protected void checkAvailableParameters() {
        // Nothing to check
    }

    /**
     * Move the console line 100 lines down, giving the illusion of clearing the
     * screen.
     */
    @Override
    protected void run() {
        for (int i = 0; i < 20; i++) {
            reader.storeln("");
        }
    }

    @Override
    public String toString() {
        return "[GameObject]interactions.commands.Clear: " + "name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

    @Override
    public void helpInfo() {
        reader.storeln("Clears the terminal.");
    }
}
