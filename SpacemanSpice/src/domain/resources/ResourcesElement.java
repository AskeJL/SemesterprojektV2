/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */

package domain.resources;

import domain.game.DomainOutput;

/**
 *
 * @author Samuel Bangslund
 */
public abstract class ResourcesElement {
    protected final ResourcesController resourcesController;
    protected final DomainOutput output = new DomainOutput();
    
    protected ResourcesElement(ResourcesController resources) {
        this.resourcesController = resources;
    }
    
    protected abstract boolean runTest();
}
