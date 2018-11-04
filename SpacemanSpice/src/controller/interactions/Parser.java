package controller.interactions;

import java.util.Scanner;

public class Parser {

    private Commands commandWords;
    private final Scanner READER = new Scanner(System.in);

    public Parser() {
        commandWords = new Commands();
    }

    public Command getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = READER.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next().toLowerCase();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next().toLowerCase();
            }
        }

        if (word1 != null && commandWords.validateCommand(word1)) {
            Command command = commandWords.getCommand(word1);
            if (command.hasParameter()) {
                if (commandWords.setCommandParameter(command, word2)) {
                    return command;
                }
            } else {
                return command;
            }
        } else {
            System.out.println("Couldn't recognize that command.");
        }

        return null;
    }

    public void showCommands() {
        for (Command command : this.commandWords.getCommandwords()) {
            System.out.println(command);
        }
    }

    public void setCommands(Commands commands) {

        this.commandWords = commands;
    }

    public Commands getCommandWords() {

        return this.commandWords;
    }

}
