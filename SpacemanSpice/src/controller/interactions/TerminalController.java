package controller.interactions;

public class TerminalController {

    /**
     * Initialize the terminal. This is required before doing anything else with
     * the class.
     */
    public static void initTerminal() {
        Commands.init();
        Command command = Parser.getCommand();
        if (command != null) {
            command.run();
        }
    }
}
