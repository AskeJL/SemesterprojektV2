package domain.interactions.commands;

import domain.interactions.Command;

public class Clear extends Command {

    public Clear() {
        super("clear", "Clears the terminal", false);
    }

    @Override
    protected void checkAvailableParameters() {
        // Nothing to check
    }

    @Override
    protected void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("");
        }
    }

    @Override
    public String toString() {
        return "interactions.commands.Clear: " + super.getDescription();
    }

    @Override
    public void helpInfo() {
        System.out.println("Clears the terminal.");
    }

}
