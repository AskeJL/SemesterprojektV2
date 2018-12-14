package data.read;

import data.AssetType;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.scene.image.Image;

/**
 * The main class for reading files.
 *
 * This is primarily used by the
 * {@link ReadController#getData(data.AssetType, java.lang.String) ReadController.getData}
 * method.
 *
 * @see Read#readTextFile()
 */
class Read {

    /**
     * File to read from. Is created during instantiation.
     *
     * @see Read(String, String)
     */
    private final File file;

    /**
     * Creates a file upon instantiation. The parameters are called from the
     * controller in the
     * {@link ReadController#getData(data.AssetType, java.lang.String) getData}
     * method.
     *
     * @param folderpath The local folder path. (Relative to /src folder)
     * @param filename The name of the file. (Remember file extentions: .txt)
     */
    Read(String folderpath, String filename) {
        this.file = new File(folderpath + filename);
    }

    /**
     * Will read the {@link Read#file file} assigned to the class - uses the
     * Scanner to read data an store it in a String List.
     *
     * @return A list of data. Each element corresponds to a line.
     */
    List<String> readTextFile() {
        List<String> data = new ArrayList<>();
        Scanner scanner;

        try {
            scanner = new Scanner(this.file);

            while (scanner.hasNext()) {
                data.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No file was found at " + file.getAbsolutePath() + "\nReturning empty.");
        }
        return data;
    }

    /**
     * Will read the {@link Read#file file} assigned to the class - uses the
     * Scanner to read an image and store it in an Image object.
     *
     * @return An Image object.
     */
    Image readImageFile() {
        return new Image(file.toURI().toString());
    }

    /**
     * Get {@link Read#file file}.
     *
     * @return
     */
    File getFile() {
        return this.file;
    }
}
