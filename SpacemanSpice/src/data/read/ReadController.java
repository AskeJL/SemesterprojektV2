package data.read;

import java.util.ArrayList;

/**
 * Controller that handles reading classes
 */
public class ReadController {

    public static ArrayList<String> getMap(String filename) {
        return new Map(filename).readTextFile();
    }
    
    public static ArrayList<String> getText(String filename) {
        return new Text(filename).readTextFile();
    }
}
