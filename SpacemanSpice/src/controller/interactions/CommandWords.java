/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package controller.interactions;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samuel Bangslund
 */
public class CommandWords {

    private List<String> commandwords = new ArrayList<>();
    
    public CommandWords(){
        
        validateCommand();
    }

    public boolean validateCommand() {
       
        return false;
    }
    
    public String getCommandwords(){
        
        for (int i = 0; i < commandwords.size(); i++) {
           return commandwords.get(i);
        }
      return commandwords.toString();
    }
    
}
