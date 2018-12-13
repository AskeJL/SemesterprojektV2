package data;

import data.read.DataReader;
import data.read.ReadController;
import data.write.DataWriter;
import data.write.WriteController;
import java.util.List;
import javafx.scene.image.Image;

/**
 * Used to access the data layer.
 * <p>
 * To access files managed by the data layer, the class can be used like so:
 * Data dataAccess = new Data(); list = dataAccess.readData(AssetType.TEXT,
 * "filename.txt"); image = dataAccess.readImage(AssetType.UI,
 * "background.png"); dataAccess.writeData(AssetType.SCORE, "highscore.txt",
 * dataAsList);
 * <p>
 * This uses the {@link data.read.ReadController} and {@link data.read.Read} to
 * read from the assets folder.
 *
 * @see data.read.DataReader
 * @see data.reader.DataWriter
 */
public class Data implements DataReader, DataWriter {

    /**
     * Reference to the ReadController().
     */
    private final ReadController reader = new ReadController();

    /**
     * Reference to the WriteController().
     */
    private final WriteController writer = new WriteController();

    /**
     * Read a .txt file based on its {@link data.AssetType} and filename. This
     * will read every line individually and return it as a list.
     *
     * @param type The type of file. Is related to the folder path.
     * @param filename The actual name of the file. (Including .txt)
     * @return A String list of each line read from the file.
     */
    @Override
    public List<String> readData(AssetType type, String filename) {
        return reader.readData(type, filename);
    }

    /**
     * Read an image file based in its {@link data.AssetType} and filename. This
     * will return an Image from the requested file.
     *
     * @param type The type of file. Is related to the folder path.
     * @param filename The actual name of the file. (Including .png etc.)
     * @return An Image.
     */
    @Override
    public Image readImage(AssetType type, String filename) {
        return reader.readImage(type, filename);
    }

    /**
     * Write a list to a .txt file. Every element in the list will be written on
     * its separate line.
     *
     * @param type The type of file. Is related to the folder path.
     * @param filename The actual name of the file. (Including .txt)
     * @param data A list of Strings.
     */
    @Override
    public void writeData(AssetType type, String filename, List<String> data) {
        writer.writeData(type, filename, data);
    }

}
