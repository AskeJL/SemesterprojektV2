
package controller.systems;

import controller.resources.ResourcesController;

/**
 * Class controlling oxygen and wave systems.
 */
public class SystemsController {
    
    private final static int SMALL_FRAGMENT_IDENTIFIER = 1;
    private final static int MEDIUM_FRAGMENT_IDENTIFIER = 2;
    private final static int LARGE_FRAGMENT_IDENTIFIER = 3;
    
    private static boolean smallFragmentDestroyed = false;
    private static boolean mediumFragmentDestroyed = false;
    private static boolean largeFragmentDestroyed = false;
    
    
    public static void update(){
        
        if(ResourcesController.getTime() == 0){
            ResourcesController.hitLife(Wave.getSmallFragments(), Wave.getMediumFragments(), Wave.getLargeFragments());
            Wave.incrementNumberOfWaves();
            Wave.createWave();
            ResourcesController.initTime();
        }
        
        if(smallFragmentDestroyed == true){
        Score.updateScore(1);
        Wave.updateWave(1);
            setSmallFragmentDestroyed(false);
        }
        if(mediumFragmentDestroyed == true){
        Score.updateScore(2);
        Wave.updateWave(2);
            setMediumFragmentDestroyed(false);
        }
        if(largeFragmentDestroyed == true){
        Score.updateScore(3);
        Wave.updateWave(3);
            setLargeFragmentDestroyed(false);
        }
    }
    
    public static int getSmallFragmentIdentifier(){
        return SMALL_FRAGMENT_IDENTIFIER;
    }
    public static int getMediumFragmentIdentifier(){
        return MEDIUM_FRAGMENT_IDENTIFIER;
    }
    public static int getLargeFragmentIdentifier(){
        return LARGE_FRAGMENT_IDENTIFIER;
    }

    public static void setSmallFragmentDestroyed(boolean aSmallFragmentDestroyed) {
        smallFragmentDestroyed = aSmallFragmentDestroyed;
    }

    public static void setMediumFragmentDestroyed(boolean aMediumFragmentDestroyed) {
        mediumFragmentDestroyed = aMediumFragmentDestroyed;
    }

    public static void setLargeFragmentDestroyed(boolean aLargeFragmentDestroyed) {
        largeFragmentDestroyed = aLargeFragmentDestroyed;
    }
    
    public static int getNumberOfSmallFragments(){
        return Wave.getSmallFragments();
    }
}


