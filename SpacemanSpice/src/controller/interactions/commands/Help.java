package controller.interactions.commands;

import controller.interactions.Command;

public class Help extends Command {

    public Help() {
        super("help", "Display the help list.", false);
        
        super.setHasParameter(false);
    }
    
    @Override
    public boolean validateCommand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean check() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        System.out.println("Printing help information.");
    }
    
    @Override
    public String toString() {
        return "controller.interactions.commands.Help: name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }
}
