package data.write;

import data.AssetType;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Used when accessing the data layer for writing.
 *
 * To reference its method, use an instance of the class that implements this.
 * new <class>().writeData(<AssetType>, <String>, List<String>);
 */
public interface DataWriter {

    /**
     * Write data to the specified file. This does not create a new file, but
     * only writes to files that already exists.
     *
     * The folder depends on the AssetType.
     *
     * @param type The type of file. (What folder it will look through)
     * @param filename The name of the file. (Remember file extensions)
     * @param data The actual data to write.
     */
    default void writeData(AssetType type, String filename, List<String> data) {
        try {
            WriteController.writeData(type, filename, data);
        } catch (FileNotFoundException ex) {
            System.out.println("The file was not found. Nothing was written.");
        }
    }
}
