package data.read;

import data.AssetType;
import java.util.List;
import javafx.scene.image.Image;

/**
 * Used when accessing the data layer for reading.
 *
 * To reference its method, use an instance of the class that implements this.
 *
 * List = this.{@link DataReader#readData(data.AssetType, java.lang.String)
 * requestData}({@link data.AssetType}, String) or List = new class().{@link DataReader#readData(data.AssetType, java.lang.String)
 * requestData}({@link data.AssetType}, String)
 *
 * @see data.write.DataWriter
 * @see Read
 * @see ReadController
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
    List<String> readData(AssetType type, String filename);

    /**
     * Request an image from the data layer. The image requested depends on the
     * {@link data.AssetType} and filename.
     *
     * @param type The type of data. {@link data.AssetType}
     * @param filename The name of the file. (Remember file extensions)
     * @return An Image.
     */
    Image readImage(AssetType type, String filename);
}
