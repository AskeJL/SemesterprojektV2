package data.write;

import data.AssetType;
import static data.AssetType.SCORE;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * This controller is assigned the job to write all specified data to designated
 * files.
 */
public class WriteController {

    private static final String SCORE_PATH = "assets/score/";

    /**
     * Writes data to a specified file.
     *
     * The function of this method demands that the file already exists.
     * Furthermore, the type specifies what folder to look through.
     *
     * @param type The type of data to write. {@link data.AssetType}
     * @param filename The name of the file. (Remember file extensions)
     * @param data The list of data it will write to the file.
     * @throws FileNotFoundException
     */
    static void writeData(AssetType type, String filename, List<String> data) throws FileNotFoundException {
        switch (type) {
            case SCORE:
                new Write(SCORE_PATH, filename).writeTextFile(data);
                break;
        }
    }
}
