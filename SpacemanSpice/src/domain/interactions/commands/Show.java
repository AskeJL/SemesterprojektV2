package domain.interactions.commands;

import domain.interactions.Command;
import domain.locations.LocationsController;
import domain.resources.ResourcesController;
import data.read.ReadController;

public class Show extends Command {
    
    public Show() {
        super("show", "Shows a resource to the player.", true);
        
        super.addParameter("oxygen");
        super.addParameter("time");
        super.addParameter("life");
        super.addParameter("map");
    }

    @Override
    protected void checkAvailableParameters() {
        super.setAvailableParameters(super.getParameters());
    }

    @Override
    protected void run() {
        switch(super.getCurrentParameter()) {
            case "oxygen":
                System.out.println("Oxygen: " + ResourcesController.getOxygen());
                break;
            case "time": 
                System.out.println("Time: " + ResourcesController.getRemainingTime());
                break;
            case "life": 
                System.out.println("Life: " + ResourcesController.getLife());
                break;
            case "map":
                System.out.println(ReadController.getMapText(LocationsController.getCurrentRoom().getName() + ".txt"));
                break;
        }
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void helpInfo() {
        System.out.println("This command displays a resource to the player, depending on its parameter."
                + "\nshow <arg>");
    }
}
