package domain.systems;

import data.AssetType;
import data.read.DataReader;
import java.util.List;

class SystemsData implements DataReader {
    
    static List<String> getTextString(String filename) {
        return new SystemsData().requestData(AssetType.TEXT, filename);
    }
    
    static void printText(List<String> text) {
        for(String line : text) {
            System.out.println(line);
        }
    }
}
