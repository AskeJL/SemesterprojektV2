package domain.resources;

public interface ResourcesReader {

    public int readCurrentTime();

    public int readRemainingTime();

    public int readLifeValue();

    public int readOxygenValue();
}
