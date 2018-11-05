package controller.interactions.commands;

import controller.interactions.Command;

public class Interact extends Command {

    public Interact() {
        super("interact", "Interact with an object.", true);
        
        super.addParameter("door");
    }

    @Override
    public void checkAvailableParameters() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        System.out.println("Interacts...");
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Interact: name[" + super.getName() + "] description[" + super.getDescription() + "] para[" + super.getCurrentParameter() + "]";
    }

}
