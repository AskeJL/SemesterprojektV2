package data.write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The main class for writing files.
 *
 * This is primarily used by the
 * {@link WriteController#writeData(data.AssetType, java.lang.String, java.util.List) WriteController.writeData}
 * method.
 */
public class Write {

    /**
     * File to write to. Is created during instantiation.
     *
     * @see Write(String, String)
     */
    private final File FILE;

    /**
     * Creates a file upon instantiation. The parameters are cllaed from the
     * controller in the
     * {@link WriteController#writeData(data.AssetType, java.lang.String, java.util.List) writeData}
     * method.
     *
     * @param folderpath The local folder path. (Relative to /src folder)
     * @param filename The name of the file. (Remember file extensions: .txt)
     */
    Write(String folderpath, String filename) {
        this.FILE = new File(folderpath + filename);
    }

    /**
     * Will write the assigned data to the {@link Write#FILE file} in the class.
     *
     * @param data Data to write to file.
     * @throws FileNotFoundException
     */
    void writeTextFile(List<String> data) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(this.FILE);

            for (String string : data) {
                writer.print(string);
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No file was found at " + FILE.getAbsolutePath() + "\nNothing was written.");
        }
    }

    /**
     * Get {@link Write#FILE file}.
     *
     * @return
     */
    File getFile() {
        return this.FILE;
    }
}
