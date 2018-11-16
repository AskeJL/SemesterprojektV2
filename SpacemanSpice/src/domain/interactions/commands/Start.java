package domain.interactions.commands;

import domain.interactions.Command;
import domain.systems.SystemsController;
import domain.tutorial.TutorialController;

/**
 * This command is responsible for starting the {@link domain.systems.Wave}.
 * When the user enters this Command, the 'game' will begin. (No more idle
 * phase)
 *
 * @see domain.systems.SystemsController
 * @see domain.systems.Wave
 */
public class Start extends Command {

    public Start() {
        super("start", "Starts the waves and score", false);
    }

    @Override
    public void checkAvailableParameters() {
        // Nothing to check
    }

    /**
     * Will set the {@link SystemsController#setPlayerReady(boolean)} to true.
     * This will make the waves active.
     * Will also set the {@link TutorialController.setTutorial(boolean)} to
     * false. This will cancel and deactivate the tutorial.
     */
    @Override
    public void run() {
        SystemsController.setPlayerReady(true);
        TutorialController.setTutorial(false);
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Start: name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

    @Override
    public void helpInfo() {
        System.out.println("The start command will start the waves and score system");
    }
}
