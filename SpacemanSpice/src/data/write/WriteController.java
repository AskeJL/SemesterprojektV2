package data.write;

import data.AssetType;
import static data.AssetType.SCORE;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Controller that handles WriteLocation and WriteScore
 */
public class WriteController {

    private static final String SCORE_PATH = "assets/score/";

    static void writeData(AssetType type, String filename, List<String> data) throws FileNotFoundException {
        switch (type) {
            case SCORE:
                new Write(SCORE_PATH, filename).writeTextFile(data);
                break;
        }
    }
}
