package presentation.tiles;

import java.util.HashMap;

/**
 * Location controller class, 
 * sets up various locations and categorizes them in a Map.
 * 
 */
public class LocationController{
    
    private Location personal;
    private Location scanner;
    private Location control;
    private Location oxygen;
    private Location outside;
    private Location net;
    private Location laser;
    
    private Location mainhall01;
    private Location mainhall02;
    private Location hallway01;
    private Location hallway02;
    
    private HashMap<String, Location> locationMap = new HashMap<>();
    
    public LocationController(){
        this.personal = new Location("Personal", "Scanner", "Mainhall01", "Hallway01", null, "personalMap.txt" );
        this.scanner = new Location("Scanner", null, "Control", "Personal", null, "scannerMap.txt");
        this.control = new Location("Control", null, "Hallway02", "Mainhall01", "Scanner", "controlMap.txt");
        this.oxygen = new Location("Oxygen", null, "Hallway02", null, "Mainhall01", "oxygenMap.txt");
        this.outside = new Location("Outside", "Hallway02", null, null, "Mainhall02", "outsideMap.txt");
        this.net = new Location("Net", "Mainhall02", null, null, "Hallway01", "netMap.txt");
        this.laser = new Location("Laser", null, "Mainhall02", null, "Hallway01", "laserMap.txt");
        
        this.mainhall01 = new Location("Mainhall01", "Control", "Oxygen", "Mainhall02", "Personal", "mainhall01Map.txt");
        this.mainhall02 = new Location("Mainhall02", "Mainhall01", "Outside", "Net", "Laser", "mainhall01Map.txt");
        this.hallway01 = new Location("Hallway01", "Personal", "Laser", "Net", null, "hallway01Map.txt");
        this.hallway02 = new Location("Hallway02", "Control", null, "Outside", "Oxygen", "hallway02Map.txt");
        
        locationMap.put(personal.getLocationDescription(), personal);
        locationMap.put(scanner.getLocationDescription(), scanner);
        locationMap.put(control.getLocationDescription(), control);
        locationMap.put(oxygen.getLocationDescription(), oxygen);
        locationMap.put(outside.getLocationDescription(),outside);
        locationMap.put(net.getLocationDescription(), net);
        locationMap.put(laser.getLocationDescription(), laser);
        
        locationMap.put(mainhall01.getLocationDescription(), mainhall01);
        locationMap.put(mainhall02.getLocationDescription(), mainhall02);
        locationMap.put(hallway01.getLocationDescription(), hallway01);
        locationMap.put(hallway02.getLocationDescription(), hallway02);
        }

    /**
     * @return the personal
     */
    public Location getPersonal() {
        return personal;
    }

    /**
     * @return the scanner
     */
    public Location getScanner() {
        return scanner;
    }

    /**
     * @return the control
     */
    public Location getControl() {
        return control;
    }

    /**
     * @return the oxygen
     */
    public Location getOxygen() {
        return oxygen;
    }

    /**
     * @return the outside
     */
    public Location getOutside() {
        return outside;
    }

    /**
     * @return the laser
     */
    public Location getLaser() {
        return laser;
    }

    /**
     * @return the mainhall01
     */
    public Location getMainhall01() {
        return mainhall01;
    }

    /**
     * @return the mainhall02
     */
    public Location getMainhall02() {
        return mainhall02;
    }

    /**
     * @return the hallway01
     */
    public Location getHallway01() {
        return hallway01;
    }

    /**
     * @return the hallway02
     */
    public Location getHallway02() {
        return hallway02;
    }

    /**
     * @return the net
     */
    public Location getNet() {
        return net;
    }

    /**
     * @param net the net to set
     */
    public void setNet(Location net) {
        this.net = net;
    }

    /**
     * @return the locationMap
     */
    public HashMap<String, Location> getLocationMap() {
        return locationMap;
    }
}
