package domain.interactions;

import domain.game.DomainOutput;

public abstract class InteractionsElement {

    protected InteractionsController interactionsController;
    protected final DomainOutput output = new DomainOutput();
    
    protected InteractionsElement() {
        
    }
    
    protected InteractionsElement(InteractionsController interact) {
        this.interactionsController = interact;
    }
}
