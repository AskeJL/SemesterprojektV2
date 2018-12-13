package domain;

/**
 * Provides a class with the {@link #update()} method. This is used when the
 * {@link Manager} is updating all of its {@link GameElement}s.
 * <p>
 *
 * Will ONLY update if the implementing class is a part of a
 * {@link GameElementGroup}.
 */
public interface GameUpdateable {

    /**
     * Update upon request. Usually called through {@link Manager}s.
     */
    public void update();
}
