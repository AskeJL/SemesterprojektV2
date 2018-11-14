package data.read;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * This controller is assigned the job to read all the different kinds of files.
 *
 * By using its associated classes, it will return the matching file as
 * requested.
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
     * @param type The type of data to read.
     * @param filename The name of the file.
     * @return A list of data.
     * @throws java.io.FileNotFoundException
     */
    public static List<String> getData(AssetType type, String filename) throws FileNotFoundException {
        switch (type) {
            case MAP:
                return new Read(MAP_PATH, filename).readTextFile();
            case TEXT:
                return new Read(TEXT_PATH, filename).readTextFile();
        }
        return null;
    }
}
