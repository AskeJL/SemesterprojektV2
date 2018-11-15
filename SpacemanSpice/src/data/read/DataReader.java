/**
 * The read package in the data layer. This package is in charge of reading data.
 */
package data.read;

import data.AssetType;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Used when accessing the data layer for reading.
 *
 * To reference its method, use an instance of the class that implements this.
 *
 * List = this.{@link DataReader#requestData(data.AssetType, java.lang.String)
 * requestData}({@link data.AssetType}, String) or List = new class().{@link DataReader#requestData(data.AssetType, java.lang.String)
 * requestData}({@link data.AssetType}, String)
 *
 * @see data.write.DataWriter
 */
public interface DataReader {

    /**
     * Request data form the data layer. The data requested depends on the
     * {@link data.AssetType} and filename.
     *
     * @param type The type of data. {@link data.AssetType}
     * @param filename The name of the file. (Remember file extensions)
     * @return A list of String of data.
     *
     * @see data.read.ReadController
     * @see data.read.Read
     */
    default List<String> requestData(AssetType type, String filename) {
        return ReadController.getData(type, filename);
    }
}
