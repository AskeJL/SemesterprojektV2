

package controller.systems;

import java.util.Random;
/**
 * Class that controls the various resources that make up a wave.
 */
public class Wave {
   private static int numberOfWaves = 0;
    
    private int smallFragments;
    private int mediumFragments;
    private int largeFragments;
    
    /**
     * Constructor 
    */
    Wave(){
        ++numberOfWaves;
        createWave();
    }
    
    /**
     * Method that creates a wave and sets values on each fragment variable
     */
    private void createWave(){
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
    
    @Override
    public String toString(){
        String s = "Number of waves: " + this.getNumberOfWaves() + "\nSmall Fragments: " + this.smallFragments + "\nMedium Fragments: " + this.mediumFragments + "\nLarge Fragments: " + this.largeFragments;
        return s;
    }
    
    public int getNumberOfWaves(){
        return numberOfWaves;
    }
    
    public void setSmallFragments(int n){
        this.smallFragments = n;
    }

    public int getSmallFragments(){
        return this.smallFragments;
    }

    public void setMediumFragments(int n){
        this.mediumFragments = n;
    }

    public int getMediumFragments(){
        return this.mediumFragments;
    }

    public void setLargeFragments(int n){
        this.largeFragments = n;
    }
    

    public int getLargeFragments(){
        return this.largeFragments;
    }
}
