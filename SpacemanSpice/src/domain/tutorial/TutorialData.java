package domain.tutorial;

import data.AssetType;
import data.read.DataReader;
import java.util.List;

public class TutorialData implements DataReader {

    static List<String> getTextString(String filename) {
        return new TutorialData().requestData(AssetType.TEXT, filename);
    }
}
