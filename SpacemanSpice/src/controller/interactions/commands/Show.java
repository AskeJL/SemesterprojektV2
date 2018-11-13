package controller.interactions.commands;

import controller.interactions.Command;
import controller.interactions.TerminalController;
import java.util.ArrayList;

public class Show extends Command {
    
    public Show() {
        super("show", "Shows a resource to the player.", true);
        
        super.addParameter("oxygen");
        super.addParameter("time");
        super.addParameter("life");
    }

    @Override
    protected void checkAvailableParameters() {
        ArrayList<String> parameters = new ArrayList<>();
        
        parameters.add("oxygen");
        parameters.add("time");
        parameters.add("life");
        
        super.setAvailableParameters(parameters);
    }

    @Override
    protected void run() {
        switch(super.getCurrentParameter()) {
            case "oxygen":
                System.out.println("Oxygen: " + TerminalController.getOxygen());
                break;
            case "time": 
                System.out.println("Time: " + TerminalController.getRemainingTime());
                break;
            case "life": 
                System.out.println("Life: " + TerminalController.getLife());
                break;
        }
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void helpInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
