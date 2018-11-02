
package controller.systems;

public class Wave {
    //Variable that holds the number of the current wave
    private int numberOfWaves;
    
    //Variables that hold the amount of fragments for each size
    private int smallFragments;
    private int mediumFragments;
    private int largeFragments;
    
    //Constructor
    Wave(){
        
    }
    
    //toString method
    @Override
    public String toString(){
        String s = "";
        return s;
    }
    
    //Set number of waves
    public void setNumberOfWaves(int n){
        this.numberOfWaves = n;
    }
    
    //Get number of waves
    public int getNumberOfWaves(){
        return this.numberOfWaves;
    }
    
    //Set number of small fragments
    public void setSmallFragments(int n){
        this.smallFragments = n;
    }
    
    //Get number of small fragments
    public int getSmallFragments(){
        return this.smallFragments;
    }
    
    //Set number of medium fragments
    public void setMediumFragments(int n){
        this.mediumFragments = n;
    }
    
    //Get number of medium fragments
    public int getMediumFragments(){
        return this.mediumFragments;
    }
    //Set number of large fragments
    public void setLargeFragments(int n){
        this.largeFragments = n;
    }
    
    //Get number of large fragments
    public int getLargeFragments(){
        return this.largeFragments;
    }
}
