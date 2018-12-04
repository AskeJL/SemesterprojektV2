package domain.interactions;

import domain.Controller;
import domain.ElementInjector;
import java.util.List;

public class InteractionsInjector implements ElementInjector<InteractionsManager, InteractionsElement> {

    @Override
    public <T extends Controller> T getManager(List<InteractionsElement> list) {
        return (T)(new InteractionsManager(list));
    }

    @Override
    public <T extends Controller> T getManager() {
        return (T) (new InteractionsManager());
    }
}
