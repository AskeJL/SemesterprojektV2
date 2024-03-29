package domain.interactions.commands;

import domain.DomainReader;
import domain.interactions.Command;
import domain.systems.SystemsManager;
import domain.tutorial.TutorialManager;

/**
 * This command is responsible for starting the {@link domain.systems.Wave}.
 * When the user enters this Command, the 'game' will begin. (No more idle
 * phase)
 *
 * @see domain.systems.SystemsController
 * @see domain.systems.Wave
 */
public class Start extends Command {

    private final SystemsManager systemsManager;
    private final TutorialManager tutorialManager;
    
    public Start(SystemsManager systems, TutorialManager tutorial) {
        super("start", "Starts the waves and score", false);
        
        this.systemsManager = systems;
        this.tutorialManager = tutorial;
    }

    @Override
    public void checkAvailableParameters() {
        // Nothing to check
    }

    /**
     * Will set the {@link SystemsController#setPlayerReady(boolean)} to true.
     * This will make the waves active. Will also set the
     * {@link TutorialController.setTutorial(boolean)} to false. This will
     * cancel and deactivate the tutorial.
     */
    @Override
    public void run() {
        systemsManager.setPlayerReady(true);
        tutorialManager.setTutorial(false);
    }

    @Override
    public String toString() {
        return "[GameObject]interactions.commands.Start: name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

    @Override
    public void helpInfo() {
        new DomainReader().storeln("The start command will start the waves and score system");
    }
}
