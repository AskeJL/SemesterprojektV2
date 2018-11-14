package data.write;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Write {
    private final File FILE;
    
    Write(String folderpath, String filename) {
        this.FILE = new File(folderpath + filename);
    }
    
    void writeTextFile(List<String> data) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(this.FILE);
        
        for(String string : data) {
            writer.print(string);
        }
    }
    
    File getFile() {
        return this.FILE;
    }
}
