package domain.interactions.commands;

import domain.interactions.Command;
import domain.interactions.InteractionsController;
import domain.locations.Exit;
import domain.locations.LocationsController;

public class Help extends Command {

    public Help() {
        super("help", "Display the help list.", true);

        super.addParameter("go");
        super.addParameter("interact");
        super.addParameter("help");
        super.addParameter("quit");
        super.addParameter("show");
        super.addParameter("clear");
    }

    @Override
    public void checkAvailableParameters() {
        super.setAvailableParameters(super.getParameters());
    }

    @Override
    public void run() {
        for (String parameter : super.getAvailableParameters()) {
            if (parameter.equalsIgnoreCase(super.getCurrentParameter())) {
                InteractionsController.getCommand(super.getCurrentParameter().toLowerCase()).helpInfo();
                return;
            }
        }
        System.out.println("What command is it you need help with?");
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Help: name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

    @Override
    public void helpInfo() {
        System.out.println("The help function can tell you which commands you can use in the given room");
    }

    @Override
    public void showAvailableParameters() {
        System.out.println("Current location: " + LocationsController.getCurrentLocation().getName());
        System.out.println("Current room: " + LocationsController.getCurrentRoom().getName());

        for (Exit exit : LocationsController.getCurrentLocation().getExits()) {
            if (exit.getFromRoom().getName().equals(LocationsController.getCurrentRoom().getName())) {
                System.out.format("You can go %-5s - %-10s\n", exit.getDirection().name().toLowerCase(), exit.getToLocation().getName());
            }
        }

        for (Exit exit : LocationsController.getCurrentRoom().getExits()) {
            System.out.format("You can go %-5s - %-10s\n", exit.getDirection().name().toLowerCase(), exit.getFromRoom().getName());
        }

        if (LocationsController.getCurrentRoom().getGameObjects().isEmpty() == false) {
            System.out.print("And you can interact with ");
            System.out.println(LocationsController.getCurrentRoom().getGameObjects().get(0).getName());
        }
        System.out.println("These are the available commands "+ super.getAvailableParameters());
        
    }
}
