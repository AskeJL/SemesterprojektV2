package domain.systems;

import domain.GameElement;
import domain.GameElementGroup;

public class Score extends GameElement {

    /**
     * The current score of this play-through.
     */
    private static int score = 0;

    /**
     * How many points a small fragment adds to the {@link #score score}.
     */
    private final static int SMALL_FRAGMENT_POINTS = 5;
    /**
     * How many points a medium fragment adds to the {@link #score score}.
     */
    private final static int MEDIUM_FRAGMENT_POINTS = 10;
    /**
     * How many points a large fragment adds to the {@link #score score}.
     */
    private final static int LARGE_FRAGMENT_POINTS = 15;

    private SystemsManager systemsManager;

    @Override
    public void init() {
        GameElementGroup group = this.gameElementGroup;
        
        this.systemsManager = (SystemsManager) group.getManager();
    }

    /**
     * Update the score. The score will be updated according to the
     * fragmentIdentifier:<br>
     * 1 : Small fragment <br>
     * 2 : Medium fragment <br>
     * 3 : Large fragment <br>
     *
     * @param fragmentIdentifier A value between 1-3. (Depending on the
     * identifier)
     */
    void update(int fragmentIdentifier) {
        if (fragmentIdentifier == systemsManager.getSmallFragmentIdentifier()) {
            score += SMALL_FRAGMENT_POINTS;
        } else if (fragmentIdentifier == systemsManager.getMediumFragmentIdentifier()) {
            score += MEDIUM_FRAGMENT_POINTS;
        } else if (fragmentIdentifier == systemsManager.getLargeFragmentIdentifier()) {
            score += LARGE_FRAGMENT_POINTS;
        }
    }

    @Override
    public String toString() {
        return "";
    }

    /**
     * Get the {@link #score score}.
     *
     * @return
     */
    public int getValue() {
        return score;
    }

    static void setValue(int value) {
        score = value;
    }
}
