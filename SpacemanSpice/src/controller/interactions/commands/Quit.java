package controller.interactions.commands;

import controller.interactions.Command;
import controller.interactions.TerminalController;

public class Quit extends Command {

    public Quit() {
        super("quit", "Quit the game.", false);
    }

    @Override
    public void checkAvailableParameters() {
        
    }

    @Override
    public void run() {
        boolean running = false;
        System.out.println("You are now exiting the game");
        System.out.println("Goodbye");
        TerminalController.setRunning(running);
    }

    @Override
    public String toString() {
        return "controller.interactions.commands.Quit: name[" + super.getName() + "] description[" + super.getDescription() + "]";
    }

    @Override
    public void helpInfo() {
        System.out.println("The quit function lets you quit the game");
    }

}
