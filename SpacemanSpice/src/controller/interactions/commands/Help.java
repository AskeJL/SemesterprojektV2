package controller.interactions.commands;

import controller.interactions.Command;
import controller.interactions.TerminalController;
import controller.locations.Exit;
import java.util.*;

public class Help extends Command {

    public Help() {
        super("help", "Display the help list.", true);

        super.addParameter("go");
        super.addParameter("interact");
        super.addParameter("help");
        super.addParameter("quit");
    }

    @Override
    public void checkAvailableParameters() {
        ArrayList<String> parameter = new ArrayList<>();
        parameter.add("go");
        parameter.add("interact");
        parameter.add("help");
        parameter.add("quit");

        super.setAvailableParameters(parameter);
    }

    @Override
    public void run() {

        if (super.getAvailableParameters().get(0).equalsIgnoreCase(super.getCurrentParameter()) && super.getCurrentParameter().equalsIgnoreCase("go")) {
            TerminalController.getCommandWords().get(0).helpInfo();
        } else if (super.getAvailableParameters().get(1).equalsIgnoreCase(super.getCurrentParameter()) && super.getCurrentParameter().equalsIgnoreCase("interact")) {
            TerminalController.getCommandWords().get(2).helpInfo();
        } else if (super.getAvailableParameters().get(2).equalsIgnoreCase(super.getCurrentParameter()) && super.getCurrentParameter().equalsIgnoreCase("help")) {
            TerminalController.getCommandWords().get(1).helpInfo();
        } else if (super.getAvailableParameters().get(3).equalsIgnoreCase(super.getCurrentParameter()) && super.getCurrentParameter().equalsIgnoreCase("quit")) {
            TerminalController.getCommandWords().get(3).helpInfo();
        } else {
            System.out.println("What command is it you need help with?");
        }
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
        System.out.println("Current location: " + TerminalController.getCurrentLocation().getName());
        System.out.println("Current room: " + TerminalController.getCurrentRoom().getName());
        for (Exit exit : TerminalController.getCurrentLocation().getExits()) {
            if (exit.getFromRoom().getName().equals(TerminalController.getCurrentRoom().getName())) {
                System.out.println("You can go " + exit.getDirection().name());
            }
        }
        for (int i = 0; i < TerminalController.getCurrentRoom().getExits().size(); i++) {
            System.out.println("You can go " + TerminalController.getCurrentRoom().getExits().get(i).getDirection().name());
        }
        if (TerminalController.getCurrentRoom().getGameObjects().isEmpty() == false){
            System.out.print("And you can interact with ");
            System.out.println(TerminalController.getCurrentRoom().getGameObjects().get(0).getName());
        }
    }
}
