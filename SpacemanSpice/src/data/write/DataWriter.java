/**
 * The write package in the data layer. This package is in charge of writing data.
 */
package data.write;

import data.AssetType;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Used when accessing the data layer for writing.
 *
 * To reference its method, use an instance of the class that implements this.
 * this.{@link DataWriter#writeData(AssetType, String, List)} or new
 * class().{@link DataWriter#writeData(AssetType, String, List)}
 *
 * @see data.read.DataReader
 */
public interface DataWriter {

    /**
     * Write data to the specified file. This does not create a new file, but
     * only writes to files that already exists.
     *
     * The folder depends on the {@link data.AssetType}.
     *
     * @param type The type of data. {@link data.AssetType}
     * @param filename The name of the file. (Remember file extensions)
     * @param data The data to write.
     *
     * @see data.write.WriteController
     * @see data.write.Write
     */
    default void writeData(AssetType type, String filename, List<String> data) {
        try {
            WriteController.writeData(type, filename, data);
        } catch (FileNotFoundException ex) {
            System.out.println("No file was found. Nothing was written.");
        }
    }
}
