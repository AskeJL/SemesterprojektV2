package domain.interfaces;

import data.read.AssetType;
import data.read.ReadController;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Used when accessing the data layer for reading.
 *
 * To reference its method, use an instance of the class that implements this.
 * List<String> data = new <class>().requestData(<AssetType>, <String>);
 */
public interface DataReader {

    /**
     * Request data form the data layer. The data requested depends on the
     * AssetType and filename.
     *
     * @param type The type of data.
     * @param filename The name of the file in that data category.
     * @return A list of String of data.
     */
    default List<String> requestData(AssetType type, String filename) {
        try {
            return ReadController.getData(type, filename);
        } catch (FileNotFoundException ex) {
            System.out.println("No file was found. Returning empty.");
        }
        return new ArrayList<>();
    }
}
