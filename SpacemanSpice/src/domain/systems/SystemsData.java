package domain.systems;

import data.AssetType;
import data.read.DataReader;
import domain.interactions.InteractionsController;
import java.util.List;

class SystemsData implements DataReader {
    
    static List<String> getTextString(String filename) {
        return new SystemsData().requestData(AssetType.TEXT, filename);
    }
    
    static List<String> getAIString(String filename) {
        return new SystemsData().requestData(AssetType.AIWAVE, filename);
    }
    
    static void printText(List<String> text) {
        for(String line : text) {
            InteractionsController.println(line);
        }
    }
}
