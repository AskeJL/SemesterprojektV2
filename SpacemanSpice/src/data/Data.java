package data;

import data.read.DataReader;
import data.read.ReadController;
import data.write.DataWriter;
import data.write.WriteController;
import java.util.List;
import javafx.scene.image.Image;

public class Data implements DataReader, DataWriter {

    private final ReadController reader = new ReadController();
    private final WriteController writer = new WriteController();
    
    public Data() {
    }
    
    @Override
    public List<String> readData(AssetType type, String filename) {
        return reader.readData(type, filename);
    }

    @Override
    public Image readImage(AssetType type, String filename) {
        return reader.readImage(type, filename);
    }

    @Override
    public void writeData(AssetType type, String filename, List<String> data) {
        writer.writeData(type, filename, data);
    }
    
}
