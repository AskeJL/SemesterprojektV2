package domain.interactions;

import domain.Controller;
import domain.GameElement;
import java.util.List;
import domain.GameUpdateable;

public class InteractionsManager extends Controller implements GameUpdateable {

    private Parser parser;
    private Commands commands;

    public InteractionsManager() {

    }

    public InteractionsManager(List<GameElement> elements) {
        super(elements);
    }

    @Override
    public void init() {
        parser = (Parser) getGameElement(Parser.class);
        commands = (Commands) getGameElement(Commands.class);

        super.init();
    }

    @Override
    public void update() {
        super.update();

//        Command command = parser.getCommand();
//        if(command != null) {
//            command.run();
//        }
    }

    @Override
    public String toString() {
        return "[Manager]interactions.InteractionsManager";
    }

    public void runCommand(String input) {
        Command command = parser.getCommand(input);
        if (command != null) {
            command.run();
        }
    }

    public Command getCommand(String input) {
        return parser.getCommand(input);
    }

    public Commands getCommands() {
        return this.commands;
    }

    public String getLastCommandName() {
        return commands.getLastCommandName();
    }

    public String getLastParameter() {
        return commands.getLastParameter();
    }
}
