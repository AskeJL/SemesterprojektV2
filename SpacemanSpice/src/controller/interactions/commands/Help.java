package controller.interactions.commands;

import controller.interactions.Command;
import controller.interactions.TerminalController;
import controller.locations.Exit;
import controller.locations.LocationsController;

public class Help extends Command {

    public Help() {
        super("help", "Display the help list.", true);

        super.addParameter("go");
        super.addParameter("interact");
        super.addParameter("help");
        super.addParameter("quit");
        super.addParameter("show");
    }

    @Override
    public void checkAvailableParameters() {
        super.setAvailableParameters(super.getParameters());
    }

    @Override
    public void run() {
        for(String parameter : super.getAvailableParameters()) {
            if(parameter.equalsIgnoreCase(super.getCurrentParameter())) {
                 TerminalController.getCommand(super.getCurrentParameter().toLowerCase()).helpInfo();
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
                System.out.println("You can go " + exit.getDirection().name());
            }
        }
        for (int i = 0; i < LocationsController.getCurrentRoom().getExits().size(); i++) {
            System.out.println("You can go " + LocationsController.getCurrentRoom().getExits().get(i).getDirection().name());
        }
        if (LocationsController.getCurrentRoom().getGameObjects().isEmpty() == false){
            System.out.print("And you can interact with ");
            System.out.println(LocationsController.getCurrentRoom().getGameObjects().get(0).getName());
        }
    }
}
