package domain.interactions.commands;

import domain.interactions.Command;
import domain.interactions.InteractionsController;

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
        InteractionsController.setRunning(running);
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