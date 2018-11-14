package domain.game;

import data.read.AssetType;
import data.read.ReadController;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public interface DataReader {

    public static List<String> requestData(AssetType type, String filename) {
        try {
            return ReadController.getData(type, filename);
        } catch (FileNotFoundException ex) {
            System.out.println("No file was found. Returning empty.");
        }
        return new ArrayList<>();
    }
}
