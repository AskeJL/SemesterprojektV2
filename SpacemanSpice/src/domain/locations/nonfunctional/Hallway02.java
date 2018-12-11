package domain.locations.nonfunctional;

import domain.locations.Exit;
import domain.locations.Location;
import domain.locations.Room;

/**
 * Nonfunctional location, that connects the functional location: Control, Oxygen, Outside.
 */
public final class Hallway02 extends Location {

    /**
     * Constructor that runs the createLocationCLI method.
     */
    public Hallway02() {
        super("Hallway 02", "The hallway connecting airlock, oxygen and navigation");
        
        createLocationCLI();
    }

    public Hallway02(Boolean gui){
                   super(
                   "Hallway02", 
                   "The hallway connecting airlock, oxygen and navigation.",
                   new Exit('w' ,"Control"),
                   null,
                   new Exit('n', "Outside"),
                   new Exit('w', "Oxygen"), 
                   "hallway02Map.txt");
    }
    
     @Override
    public void init() {
       
    }
    
    @Override
    protected void createLocationCLI() {
        /*The room in the hallway02 location are created----------------------*/
        
        /*Hallway 02----------------------------------------------------------*/
        Room hallway02 = new Room("Hallway 02","This hallway connects the airlock, navigation and oxygen");
        super.addRoom(hallway02);
    }

    @Override
    public String toString() {
        return "locations.Room : Name[" + this.getName() + "] Description[" + this.getDescription() +" The exits are"+ this.getExits()+ "]";
    }

   
}
