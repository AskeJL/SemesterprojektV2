package domain.interactions.commands;

import domain.interactions.Command;
import domain.interactions.InteractionsController;

/**
 * This command is responsible for clearing the screen when prompted.
 *
 * @see domain.interactions.Command
 * @see domain.interactions.Commands
 */
public class Clear extends Command {

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
            InteractionsController.println("");
        }
    }

    @Override
    public String toString() {
        return "interactions.commands.Clear: " + super.getDescription();
    }

    @Override
    public void helpInfo() {
        InteractionsController.println("Clears the terminal.");
    }
}
