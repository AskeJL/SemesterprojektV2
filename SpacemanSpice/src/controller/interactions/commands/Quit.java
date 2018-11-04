package controller.interactions.commands;

import controller.interactions.Command;

public class Quit extends Command {

    public Quit() {
        super("quit", "Quit the game.", false);
        
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
        System.out.println("Quitting the game");
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Quit: name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

}
