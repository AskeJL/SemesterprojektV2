
package domain.systems;

/**
 * Class that keeps track of score.
 */
public class Score {
    
    private static int score = 0;
    
    private final static int SMALL_FRAGMENT_POINTS = 5;
    private final static int MEDIUM_FRAGMENT_POINTS = 10;
    private final static int LARGE_FRAGMENT_POINTS = 15;
    
    private Score(){}
    /**
     * Method that updates score, based on fragment type.
     * @param fragmentIdentifier 
     */
    static void updateScore(int fragmentIdentifier){
        if(fragmentIdentifier == SystemsController.getSmallFragmentIdentifier()){
            score += SMALL_FRAGMENT_POINTS;
        }
        if(fragmentIdentifier == SystemsController.getMediumFragmentIdentifier()){
            score += MEDIUM_FRAGMENT_POINTS;
        }
        if(fragmentIdentifier == SystemsController.getLargeFragmentIdentifier()){
            score += LARGE_FRAGMENT_POINTS;
        }
    }
    
    @Override
    public String toString(){
      String s = "";
      return s;
    }
    
    static int getScore(){
        return score;
    }
}
