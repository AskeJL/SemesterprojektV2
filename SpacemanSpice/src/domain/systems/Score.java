package domain.systems;

/**
 * This keeps track of the score that the player achieves throughout the game.
 * The score depends on how many (and of which) fragments are destroyed.
 *
 * @see domain.locations.functional.Laser
 * @see domain.locations.functional.Net
 * @see domain.locations.functional.Control
 * @see SystemsController
 * @see Wave
 */
public class Score {

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

    private Score() {
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
    static void updateScore(int fragmentIdentifier) {
        if (fragmentIdentifier == SystemsController.getSmallFragmentIdentifier()) {
            score += SMALL_FRAGMENT_POINTS;
        }
        if (fragmentIdentifier == SystemsController.getMediumFragmentIdentifier()) {
            score += MEDIUM_FRAGMENT_POINTS;
        }
        if (fragmentIdentifier == SystemsController.getLargeFragmentIdentifier()) {
            score += LARGE_FRAGMENT_POINTS;
        }
    }

    @Override
    public String toString() {
        String s = "";
        return s;
    }

    /**
     * Get the {@link #score score}.
     *
     * @return
     */
    static int getScore() {
        return score;
    }
}
