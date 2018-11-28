package domain.interactions.commands;

import domain.interactions.Command;
import domain.interactions.InteractionsController;

/**
 * This command is responsible for continuing a dialog when prompted.
 *
 * @see domain.interactions.Command
 * @see domain.interactions.Commands
 * @see domain.tutorial.TutorialController
 */
public class Continue extends Command {

    public Continue(InteractionsController interactions) {
        super(interactions, "continue", "Continues the dialogue", false);
    }

    @Override
    protected void checkAvailableParameters() {

    }

    /**
     * Empty run as this command is only intended to progress through the
     * {@link domain.interactions.InteractionsController#update() InteractionsController.update().}
     */
    @Override
    protected void run() {
        
    }

    @Override
    public String toString() {
        return "domain.interactions.commands.Continue: name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

    @Override
    public void helpInfo() {
        output.println("This command lets you continue a dialogue.");
    }

    @Override
    protected boolean runTest() {
        return true;
    }
}
