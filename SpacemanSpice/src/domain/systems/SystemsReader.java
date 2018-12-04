package domain.systems;

public interface SystemsReader {

    public int readSmallFragments();

    public int readMediumFragments();

    public int readLargeFragments();
    
    public int readNumberOfWaves();
}
