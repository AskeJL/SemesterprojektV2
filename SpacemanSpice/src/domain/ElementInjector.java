package domain;

import java.util.List;

public interface ElementInjector<T, S> {

    public <T extends Controller> T getManager(List<S> list);
    
    public <T extends Controller> T getManager();
}
