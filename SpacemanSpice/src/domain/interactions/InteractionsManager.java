package domain.interactions;

import domain.GameElementGroup;
import domain.Manager;
import domain.GameUpdateable;

public class InteractionsManager extends Manager implements GameUpdateable {

    private Parser parser;
    private Commands commands;

    public InteractionsManager() {

    }

    @Override
    public void init() {
        GameElementGroup group = this.getGameElementGroup();
        parser = (Parser) group.getGameElement(Parser.class);
        commands = (Commands) group.getGameElement(Commands.class);
        
        super.init();
    }

    @Override
    public void update() {
        super.update();
    }

    public void runCommand(String input) {
        Command command = parser.getCommand(input);
        if (command != null) {
            command.run();
        }
    }

    @Override
    public String toString() {
        String info = "domain.interactions.InteractionsManager";
        info += super.toString();
        return info;
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
