package data.write;

import data.AssetType;
import java.io.FileNotFoundException;
import java.util.List;

public interface DataWriter {

    default void writeData(AssetType type, String filename, List<String> data) {
        try {
            WriteController.writeData(type, filename, data);
        } catch (FileNotFoundException ex) {
            System.out.println("The file was not found. Nothing was written.");
        }
    }
}
