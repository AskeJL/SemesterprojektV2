package domain.locations.gameobjects;

import domain.DomainReader;
import domain.DomainRequester;
import domain.locations.GameObject;
import domain.locations.GameObjectType;
import domain.systems.SystemsManager;
import domain.systems.Wave;

/**
 * Used to scan the vicinity of the ship for fragments.
 * <p>
 * This {@link GameObject} is of the {@link GameObjectType#CONTROL} type.
 *
 * @see GameObject
 * @see domain.locations.functional.Scanning
 */
public class ControllerScanning extends GameObject {

    private final SystemsManager systemsManager;
    private final DomainReader reader = new DomainReader();
    private final DomainRequester requester = new DomainRequester();

    public ControllerScanning(SystemsManager systems) {
        super("Scanning control", "This is the scanningstation", GameObjectType.CONTROL, null);

        this.systemsManager = systems;
    }

    /**
     * Inform the player about the current amount of fragments. (small, medium
     * and large)
     *
     * @see domain.systems.Wave
     * @see domain.systems.SystemsController
     */
    @Override
    public void interact() {
        requester.playConsoleSound();
        reader.storeln("You interact with the scanning station.");
        Wave wave = systemsManager.getWave();
        if ((wave.getSensor1currentValue() == wave.getSensor1MaxValue())
                && (wave.getSensor2currentValue() == wave.getSensor2MaxValue())
                && (wave.getSensor3currentValue() == wave.getSensor3MaxValue())
                && (wave.getSensor4currentValue() == wave.getSensor4MaxValue())) {

            reader.storeln("You interact with the scanningstation\nThere are:\n"
                    + "    " + systemsManager.getWave().getSmallFragments() + " small fragments.\n"
                    + "    " + systemsManager.getWave().getMediumFragments() + " medium fragments.\n"
                    + "    " + systemsManager.getWave().getLargeFragments() + " large fragments.\n");
        }
        else{
            wave.setSensor1currentValue(0);
            wave.setSensor2currentValue(0);
            wave.setSensor3currentValue(0);
            wave.setSensor4currentValue(0);
            reader.storeln("Cannot scan at the moment, sensors need to be calibrated as such:");
            reader.storeln("Sensor 1 at: " + wave.getSensor1MaxValue());
            reader.storeln("Sensor 2 at: " + wave.getSensor2MaxValue());
            reader.storeln("Sensor 3 at: " + wave.getSensor3MaxValue());
            reader.storeln("Sensor 4 at: " + wave.getSensor4MaxValue());
        }
        }

        @Override
        public String toString
        
            () {
        return super.getName() + super.getDescription();
        }
    }
