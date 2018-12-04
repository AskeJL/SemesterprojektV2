package domain;

import domain.interactions.InteractionsManager;
import domain.interactions.InteractionsRequest;

public class DomainRequester implements InteractionsRequest {

    private static ControlGroup group;

    void init(ControlGroup group) {
        DomainRequester.group = group;
    }

    @Override
    public void requestRunCommand(String input) {
        InteractionsManager interactions = (InteractionsManager) group.fetchController(InteractionsManager.class);

        if (interactions != null) {
            interactions.runCommand(input);
        }
    }
}
