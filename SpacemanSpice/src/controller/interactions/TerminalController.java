/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */
package controller.interactions;

/**
 *
 * @author Samuel Bangslund
 */
public class TerminalController {

    public static void initTerminal() {
        Parser parser = new Parser();
        parser.showCommands();
        
        Command command = parser.getCommand();
        if (command != null) {
            command.run();
        }
    }
}
