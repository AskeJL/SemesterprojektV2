package data.read;

import java.util.List;

/**
 * This controller is assigned the job to read all the different kinds of files.
 *
 * By using its associated classes, it will return the matching file as
 * requested.
 */
public class ReadController {

    /**
     * Get the map that matches the inserted filename parameter. Will return a
     * List of all the lines in the .txt file.
     *
     * @param filename Name of the Map.
     * @return A List of all the lines in the .txt file.
     */
    public static List<String> getMap(String filename) {
        return new Map(filename).readTextFile();
    }

    /**
     * Get the text that matches the inserted filename parameter. Will return a
     * List of all the lines in the .txt file.
     *
     * @param filename Name of the Text.
     * @return A list of all the lines in the .txt file.
     */
    public static List<String> getText(String filename) {
        return new Text(filename).readTextFile();
    }
}
