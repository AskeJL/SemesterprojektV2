package data.read;

import data.AssetType;
import java.util.ArrayList;
import java.util.List;

/**
 * This controller is assigned the job to read all the different kinds of files.
 *
 * The controller is called from the {@link DataReader} interface, which is the
 * only bridge to the data.read layer.
 */
class ReadController {

    private static final String MAP_PATH = "assets/maps/";
    private static final String TEXT_PATH = "assets/text/";
    private static final String DESCRIPTION_PATH = "assets/descriptions/";
    private static final String AI_PATH = "assets/text/AI behaviour/";
    private static final String SCORE_PATH = "assets/score/";

    /**
     * Gets data based on its {@link data.AssetType} and name.
     *
     * The types uses the Enum, AssetType which dictates where to look for the
     * given file. The filename is the actual name of the file - this also
     * includes its file extension.
     *
     * @param type The type of data to read. {@link data.AssetType}
     * @param filename The name of the file. (Remember file extensions)
     * @return A list of data.
     *
     * @see data.AssetType
     */
    static List<String> getData(AssetType type, String filename) {
        switch (type) {
            case MAP:
                return new Read(MAP_PATH, filename).readTextFile();
            case TEXT:
                return new Read(TEXT_PATH, filename).readTextFile();
            case DESCRIPTION:
                return new Read(DESCRIPTION_PATH, filename).readTextFile();
            case AIWAVE:
                return new Read(AI_PATH, filename).readTextFile();
            case SCORE:
                return new Read(SCORE_PATH, filename).readTextFile();
            default:
                return new ArrayList<>();
        }
    }
}
