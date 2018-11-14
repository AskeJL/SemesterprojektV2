package data.read;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads files based on its inherited classes.
 *
 * If you want to read a document(.txt) use the Text class. If you want to read
 * a map(.txt) use the Map class.
 */
class Read {

    /**
     * File to read from. Is created during instantiation.
     */
    private final File FILE;

    /**
     * Creates a file upon instantiation. The parameters are called from the
     * inherited classes.
     *
     * @param folderpath The local folder path. (Relative to /src folder)
     * @param filename The name of the file. (Remember file extentions: .txt)
     */
    Read(String folderpath, String filename) {
        this.FILE = new File(folderpath + filename);
    }

    /**
     * Will read the file assigned to the class. The file gets assigned upon
     * instantiation from inherited classes { Text, Map etc. }.
     *
     * @return A list of data. Each element corresponds to a line.
     */
    List<String> readTextFile() throws FileNotFoundException {
        List<String> data = new ArrayList<>();
        Scanner scanner;
        
        scanner = new Scanner(this.FILE);

        while (scanner.hasNext()) {
            data.add(scanner.nextLine());
        }
        scanner.close();
        return data;
    }

    File getFile() {
        return this.FILE;
    }
}
