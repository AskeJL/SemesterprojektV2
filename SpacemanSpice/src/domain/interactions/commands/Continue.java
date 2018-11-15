
package domain.interactions.commands;

import domain.interactions.Command;
import domain.tutorial.TutorialController;

/**
 *
 * @author Oliver
 */
public class Continue extends Command{
    
    public Continue(){
        super("continue", "Continues the dialogue", false);
    }
    @Override
    protected void checkAvailableParameters() {
        
    }

    @Override
    protected void run() {
        TutorialController.setContinuing();
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Continue: name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

    @Override
    public void helpInfo() {
        System.out.println("This command lets you continue a dialogue.");
    }
    
}
