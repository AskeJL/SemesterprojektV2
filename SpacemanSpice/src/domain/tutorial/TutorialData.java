package domain.tutorial;

import data.AssetType;
import data.read.DataReader;
import domain.interactions.InteractionsController;
import java.util.List;
import presentation.PresentationRequest;

/**
 * Responsible for reading and printing data for the tutorial/introduction.
 * <br><br>
 * Because of its reference to the data-layer this class implements the
 * {@link DataReader} interface.
 *
 * @see TutorialController
 * @see DataReader
 */
class TutorialData implements DataReader, PresentationRequest {

    private static TutorialData interfaces = new TutorialData();
    
    /**
     * Request data from the data-layer using
     * {@link TutorialData#requestData(data.AssetType, java.lang.String)}.
     *
     * @param filename The name of the file.
     * @return
     */
    static List<String> getTextString(String filename) {
        return interfaces.requestData(AssetType.TEXT, filename);
    }

    /**
     * Print a List of Strings to the console.
     *
     * @param text List to print.
     */
    static void println(List<String> text) {
        for (String string : text) {
            InteractionsController.println(string);
        }
    }
}
