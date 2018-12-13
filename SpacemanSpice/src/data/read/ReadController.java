package data.read;

import data.AssetType;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;

/**
 * This controller is assigned the job to read all the different kinds of files.
 *
 * The controller is called from the {@link DataReader} interface, which is the
 * only bridge to the data.read layer.
 */
public class ReadController {

    private static final String PATH_MAP = "assets/maps/";
    private static final String PATH_TEXT = "assets/text/";
    private static final String PATH_DESCRIPTION = "assets/descriptions/";
    private static final String PATH_AI = "assets/text/AI behaviour/";
    private static final String PATH_SCORE = "assets/score/";
    private static final String PATH_UI = "assets/UI/";

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
    public List<String> readData(AssetType type, String filename) {
        switch (type) {
            case MAP:
                return new Read(PATH_MAP, filename).readTextFile();
            case TEXT:
                return new Read(PATH_TEXT, filename).readTextFile();
            case DESCRIPTION:
                return new Read(PATH_DESCRIPTION, filename).readTextFile();
            case AIWAVE:
                return new Read(PATH_AI, filename).readTextFile();
            case SCORE:
                return new Read(PATH_SCORE, filename).readTextFile();
            default:
                return new ArrayList<>();
        }
    }

    public Image readImage(AssetType type, String filename) {
        switch (type) {
            case UI:
                return new Read(PATH_UI, filename).readImageFile();
            default:
                System.out.println("Nothing was found at " + type + " " + filename + ". \nReturning null.");
                return null;
        }
    }
}
