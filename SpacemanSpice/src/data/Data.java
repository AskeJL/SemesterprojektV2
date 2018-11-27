/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import data.read.DataReader;
import data.read.ReadController;
import data.write.DataWriter;
import data.write.WriteController;
import java.util.List;

/**
 *
 * @author sbang
 */
public class Data implements DataReader, DataWriter {

    private final ReadController reader = new ReadController();
    private final WriteController writer = new WriteController();
    
    public Data() {
    }
    
    @Override
    public List<String> requestData(AssetType type, String filename) {
        return reader.readData(type, filename);
    }

    @Override
    public void writeData(AssetType type, String filename, List<String> data) {
        writer.writeData(type, filename, data);
    }
    
}
