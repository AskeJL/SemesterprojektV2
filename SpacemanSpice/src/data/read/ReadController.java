package data.read;

import data.AssetType;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * This controller is assigned the job to read all the different kinds of files.
 */
public class ReadController {

    private static final String MAP_PATH = "assets/maps/";
    private static final String TEXT_PATH = "assets/text/";

    /**
     * Gets data based on its type and name.
     *
     * The types uses the Enum, AssetType which dictates where to look for the
     * given file. The filename is the actual name of the file, this also
     * includes its file extension.
     *
     * @param type The type of data to read. (What folder to look through)
     * @param filename The name of the file. (Remember file extensions)
     * @return A list of data.
     * @throws java.io.FileNotFoundException
     */
    static List<String> getData(AssetType type, String filename) throws FileNotFoundException {
        switch (type) {
            case MAP:
                return new Read(MAP_PATH, filename).readTextFile();
            case TEXT:
                return new Read(TEXT_PATH, filename).readTextFile();
            default:
                return new ArrayList<>();
        }
    }
}
