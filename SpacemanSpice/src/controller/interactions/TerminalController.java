package controller.interactions;

public class TerminalController {

    public static void initTerminal() {
        Commands.init();
        Command command = Parser.getCommand();
        if (command != null) {
            command.run();
        }
    }
}
