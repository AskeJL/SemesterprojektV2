package data.read;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {

    private final File FILE;

    protected Read(String folderpath, String filename) {
        this.FILE = new File(folderpath + filename);
    }

    protected ArrayList<String> readTextFile() {
        ArrayList<String> data = new ArrayList<>();
        Scanner scanner;
        try {
            scanner = new Scanner(this.FILE);
            
            while(scanner.hasNext()) {
                data.add(scanner.nextLine());
            }
            return data;
        } catch (FileNotFoundException ex) {
            System.out.println("This file does not exist. " + this.FILE.getAbsolutePath());
        }
        return null;
    }
    
    protected File getFile() {
        return this.FILE;
    }
}
