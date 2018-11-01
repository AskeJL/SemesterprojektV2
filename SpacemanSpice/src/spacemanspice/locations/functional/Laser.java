package spacemanspice.locations.functional;

import spacemanspice.locations.Exit;
import spacemanspice.locations.ExitDirection;
import spacemanspice.locations.Location;
import spacemanspice.locations.Room;

public final class Laser extends Location {

    public Laser() {
        super("Laser", "The laser is operated from here.");

        createLocation();
    }

    @Override
    protected void createLocation() {
        /*The rooms in the laser location are created-------------------------*/

        /*Corridor------------------------------------------------------------*/
        Room corridorRoom = new Room("Laser corridor", "Main corridor for the laser.");
        super.addRoom(corridorRoom);

        /*Technic-------------------------------------------------------------*/
        Room technicRoom = new Room("Laser technic", "The technical parts of the laser.");
        super.addRoom(technicRoom);

        /*Controls------------------------------------------------------------*/
        Room controlsRoom = new Room("Laser controls", "The controls for the laser.");
        super.addRoom(controlsRoom);

        /*Setting exits and entrances-----------------------------------------*/
        super.addEntrance(corridorRoom);

        corridorRoom.addExit(new Exit(ExitDirection.NORTH, technicRoom));
        corridorRoom.addExit(new Exit(ExitDirection.SOUTH, controlsRoom));

        technicRoom.addExit(new Exit(ExitDirection.SOUTH, corridorRoom));
        controlsRoom.addExit(new Exit(ExitDirection.NORTH, corridorRoom));
    }

    @Override
    public String toString() {
        return "locations.functional.Laser : Name[" + this.getName() + "] Description[" + this.getDescription() + "]";
    }
}
