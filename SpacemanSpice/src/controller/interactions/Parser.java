/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package controller.interactions;

import java.util.Scanner;

/**
 *
 * @author Samuel Bangslund
 */
public class Parser {

    private CommandWords commands;
    private Scanner reader;
    
    public Parser(){
        
        commands = new CommandWords();
        reader = new Scanner(System.in);
        
    }
    
    public Command getCommand(){
      
        return Command;
    }
    
    public void showCommands(){
        
    }
    
    public void setCommands(CommandWords commands){
        
        this.commands = commands;
    }
    
    public CommandWords getCommands(){
        
        return this.commands;
    }
    
}
