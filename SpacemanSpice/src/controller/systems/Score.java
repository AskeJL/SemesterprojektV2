
package controller.systems;

/**
 * Class that keeps track of score.
 */
public class Score {
    
    private static int score;
    
    private final int SMALL_FRAGMENT_POINTS = 5;
    private final int MEDIUM_FRAGMENT_POINTS = 10;
    private final int LARGE_FRAGMENT_POINTS = 15;
    
    /**
     * Score constructor.
     */
    Score(){
       score = 0; 
    }
    
    /**
     * Method that updates score, based on fragment type.
     * @param fragmentType 
     */
    public void updateScore(int fragmentType){
        if(fragmentType == 1){
            score += SMALL_FRAGMENT_POINTS;
        }
        if(fragmentType == 2){
            score += MEDIUM_FRAGMENT_POINTS;
        }
        if(fragmentType == 3){
            score += LARGE_FRAGMENT_POINTS;
        }
    }
    
    @Override
    public String toString(){
      String s = "";
      return s;
    }
    
    public void getScore(){
        
    }
}
