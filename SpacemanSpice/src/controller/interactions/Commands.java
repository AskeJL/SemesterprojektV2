package controller.interactions;

import controller.interactions.commands.*;
import java.util.ArrayList;
import java.util.List;

public class Commands {

    private final List<Command> commandwords = new ArrayList<>();
    
    public Commands(){
        commandwords.add(new Go());
        commandwords.add(new Help());
        commandwords.add(new Interact());
        commandwords.add(new Quit());
    }

    public boolean validateCommand(String commandword) {
       for(Command command : this.commandwords) {
           if(commandword.equals(command.getName())) {
               return true;
           }
       }
       return false;
    }
    
    public boolean setCommandParameter(Command command, String parameter) {
        for(int i = 0; i < this.commandwords.size(); i++) {
            Command c = this.commandwords.get(i);
            if(c.equals(command) && c.hasParameter() && c.checkParameter(parameter)) {
                c.setCurrentParameter(parameter);
                return true;
            } else if(c.equals(command) && c.hasParameter()) {
                System.out.println("I do not understand that parameter.");
            }
        }
        return false;
    }
    
    public Command getCommand(int index) {
        return this.commandwords.get(index);
    }
    
    public Command getCommand(String name) {
        for(Command command : this.commandwords) {
            if (name.equals(command.getName())) {
                return command;
            }
        }
        return null;
    }
    
    public List<Command> getCommandwords(){
        return this.commandwords;
    }
    
}
