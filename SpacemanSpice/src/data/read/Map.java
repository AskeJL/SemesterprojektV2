package data.read;

/**
 * A file located in the assets/maps/ folder. Use this to access map files.
 */
public class Map extends Read {

    /**
     * Read a Map with the matching filename. Will only look in the assets/maps/
     * folder relative to the Netbeans project.
     *
     * @param filename Name of the Map.
     */
    Map(String filename) {
        super("assets/maps/", filename);
    }
}
