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

    public Clear(InteractionsController interactions) {
        super(interactions, "clear", "Clears the terminal", false);
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
            output.println("");
        }
    }

    @Override
    public String toString() {
        return "domain.interactions.commands.Clear: " + "name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

    @Override
    public void helpInfo() {
        output.println("Clears the terminal.");
    }

    @Override
    protected boolean runTest() {
        return true;
    }
}
