package controller.interactions.commands;

import controller.interactions.Command;

public class Go extends Command {

    public Go() {
        super("go", "Walk the player in a direction. [North, South, West, East]", true);
        
        super.addParameter("north");
        super.addParameter("west");
        super.addParameter("east");
        super.addParameter("south");
    }

    @Override
    public boolean check() {
        
    }
    
    @Override
    public void run() {
        System.out.println("Goes " + super.getCurrentParameter());
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Go: name[" + super.getName() + "] description[" + super.getDescription() + "] para[" + super.getCurrentParameter() + "]";
    }
    
}
