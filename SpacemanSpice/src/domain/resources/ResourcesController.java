package domain.resources;

import domain.game.Controller;
import domain.game.DomainOutput;
import domain.game.Game;
import domain.interactions.InteractionsController;
import domain.locations.LocationsController;
import domain.systems.SystemsController;

/**
 * The main controller for the domain.resources package. This will control all
 * the other classes within the package.
 *
 * @see Life
 * @see Oxygen
 * @see Time
 */
public class ResourcesController extends Controller {

    private final Game game;

    private InteractionsController interactionsController;
    private LocationsController locationsController;

    private final DomainOutput output = new DomainOutput();

    private Time time;
    private Oxygen oxygen;
    private Life life;

    public ResourcesController(Game game) {
        super(game);

        this.game = game;
    }

    /**
     * Initialize the {@link domain.game.Controller controller}. Will initialize
     * needed classes.
     */
    @Override
    public void init() {
        locationsController = (LocationsController) game.getController(new LocationsController(game));
        interactionsController = (InteractionsController) game.getController(new InteractionsController(game));

        this.time = new Time(this);
        this.oxygen = new Oxygen(this);
        this.life = new Life(this);
    }

    /**
     * Update the {@link domain.game.Controller controller}.
     * <p>
     * As well as updating the some of the classes this will also look for
     * changes regarding {@link Life} and {@link Oxygen}. If one of them reaches
     * below 0, the {@link domain.game.Game} will end.
     */
    @Override
    public void update() {
        time.update();
        oxygen.update();

        if (oxygen.getOxygen() <= 0) {
            output.println("You are out of oxygen. Too bad, you are dead..");
            output.println("Score: " + SystemsController.getScore());
        }
        life.update();
        if (life.getLife() <= 0) {
            output.println("The ship is destroyed. Too bad, you are dead..");
            output.println("Score: " + SystemsController.getScore());
        }
    }

    /**
     * Decrease the {@link Life} of the hull based on the amount of fragments.
     * This calls the {@link Life#decreaseLife(int, int, int)} method.
     *
     * @param hitSmallFragments Amount of small fragments that hit.
     * @param hitMediumFragments Amount of medium fragments that hit.
     * @param hitLargeFragments Amount of Large fragments that hit.
     */
    public void decreaseLife(int hitSmallFragments, int hitMediumFragments, int hitLargeFragments) {
        life.decreaseLife(hitSmallFragments, hitMediumFragments, hitLargeFragments);
    }

    /**
     * Increase the {@link Oxygen#oxygen} from {@link Oxygen}. Uses the
     * {@link Oxygen#increaseOxygen(int)} method.
     *
     * @param oxygenValue Amount to increase with.
     */
    public void increaseOxygen(int oxygenValue) {
        oxygen.increaseOxygen(oxygenValue);
    }

    public void setRepairTrue() {
        life.setRepairTrue();
    }

    public void setWaveTime(long newWaveTime) {
        time.setWaveTime(newWaveTime);
    }

    /**
     * Get the {@link Time#currentTime} from {@link Time}.
     *
     * @return
     */
    public long getCurrentTime() {
        return time.getCurrentTime();
    }

    /**
     * Get the {@link Time#initTime} from {@link Time}.
     *
     * @return
     */
    public long getInitTime() {
        return time.getInitTime();
    }

    /**
     * Get the {@link Oxygen#oxygen} from {@link Oxygen}.
     *
     * @return
     */
    public int getOxygenValue() {
        return oxygen.getOxygen();
    }

    /**
     * Get the {@link Life#life} from {@link Life}.
     *
     * @return
     */
    public int getLifeValue() {
        return life.getLife();
    }

    /**
     * Get the {@link Time#getRemainingTime()} from {@link Time}.
     *
     * @return
     */
    public long getRemainingTime() {
        if (SystemsController.getPlayerReady()) {
            return time.getRemainingTime();
        }
        long nullTime = 0;
        return nullTime;
    }

    /**
     * Get the {@link Time#waveTime} from {@link Time}.
     *
     * @return
     */
    public long getWaveTime() {
        return time.getWaveTime();
    }

    public void setRandomTime() {
        time.setRandTime();
    }

    public long getRandomTime() {
        return time.getRandTime();
    }

    InteractionsController getInteractionsController() {
        return this.interactionsController;
    }

    LocationsController getLocationsController() {
        return this.locationsController;
    }

    Oxygen getOxygen() {
        return this.oxygen;
    }

    Time getTime() {
        return this.time;
    }

    Life getLife() {
        return this.life;
    }

    @Override
    public boolean runTest() {
        return true;
    }
}
