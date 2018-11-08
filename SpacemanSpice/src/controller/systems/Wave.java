

package controller.systems;

import java.util.Random;
/**
 * Class that controls the various resources that make up a wave.
 */
public class Wave {
   private static int numberOfWaves = 0;
    
    private static int smallFragments;
    private static int mediumFragments;
    private static int largeFragments;
    
        
    /**
     * Method that creates a wave and sets values on each fragment variable
     */
    public static void createWave(){
        Random random = new Random();
        smallFragments = (random.nextInt(3)+1)*numberOfWaves;
        
        if(numberOfWaves%2==0){
            mediumFragments = numberOfWaves/2;
        }
        else mediumFragments = 0;
        
        if(numberOfWaves%3==0){
            largeFragments = numberOfWaves/3;
        }
        else largeFragments = 0;
    }
    public static void updateWave(int fragmentIdentifier){
        if(fragmentIdentifier == SystemsController.getSmallFragmentIdentifier()){
            --smallFragments;
        if(smallFragments < 0){
            smallFragments = 0;
        }
        }
        if(fragmentIdentifier == SystemsController.getMediumFragmentIdentifier()){
             --mediumFragments;
        if(mediumFragments < 0){
            mediumFragments = 0;
        }
        }
        if(fragmentIdentifier == SystemsController.getLargeFragmentIdentifier()){
             largeFragments=0;
        if(largeFragments < 0){
            largeFragments = 0;
        }
        }
    }
    @Override
    public String toString(){
        String s = "";
        return s;
    }
    /**
     * Increase number of waves by 1.
     */
    static void incrementNumberOfWaves(){
        numberOfWaves++;
    }

    static int getSmallFragments(){
        return smallFragments;
    }

    static int getMediumFragments(){
        return mediumFragments;
    }
    static int getLargeFragments(){
        return largeFragments;
    }
}
