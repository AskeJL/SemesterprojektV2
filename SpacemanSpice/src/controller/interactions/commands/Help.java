package controller.interactions.commands;

import controller.interactions.Command;
import controller.interactions.Commands;
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
            Commands.getCommandwords().get(0).helpInfo();
        } else if (super.getAvailableParameters().get(1).equalsIgnoreCase(super.getCurrentParameter()) && super.getCurrentParameter().equalsIgnoreCase("interact")) {
            Commands.getCommandwords().get(2).helpInfo();
        } else if (super.getAvailableParameters().get(2).equalsIgnoreCase(super.getCurrentParameter()) && super.getCurrentParameter().equalsIgnoreCase("help")) {
            Commands.getCommandwords().get(1).helpInfo();
        } else if (super.getAvailableParameters().get(3).equalsIgnoreCase(super.getCurrentParameter()) && super.getCurrentParameter().equalsIgnoreCase("quit")) {
            Commands.getCommandwords().get(3).helpInfo();
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
}
