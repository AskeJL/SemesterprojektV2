package domain.interactions.commands;

import domain.interactions.Command;
import domain.interactions.InteractionsController;

/**
 * This command is responsible for quitting the game when prompted. Calls the
 * {@link InteractionsController#setRunning(boolean)} method.
 *
 * @see domain.game.Controller
 * @see domain.game.Game
 */
public class Quit extends Command {

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
        InteractionsController.setRunning(false);
        InteractionsController.println("You are now exiting the game - thank you for playing!"
                + "\nGoodbye...");
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Quit: name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

    @Override
    public void helpInfo() {
        InteractionsController.println("The quit function lets you quit the game");
    }
}
