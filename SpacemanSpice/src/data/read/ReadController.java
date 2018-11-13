package data.read;

/**
 * Controller that handles reading classes
 */
public class ReadController {

    public static String getMapText(String name) {
        return new Map(name).readTextFile();
    }
}
