

package controller.systems;

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
        smallFragments = numberOfWaves * 2;
        mediumFragments = (numberOfWaves/2);
        largeFragments = (numberOfWaves/3);
    }
    
    //toString method
    @Override
    public String toString(){
        String s = "Number of waves: " + this.getNumberOfWaves() + "\nSmall Fragments: " + this.smallFragments + "\nMedium Fragments: " + this.mediumFragments + "\nLarge Fragments: " + this.largeFragments;
        return s;
    }
    
    public int getNumberOfWaves(){
        return this.numberOfWaves;
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
