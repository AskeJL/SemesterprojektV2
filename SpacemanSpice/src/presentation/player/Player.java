
package presentation.player;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import presentation.game.GameViewController;

public class Player {
    
    private final int TILE_WIDTH = 32;
    private final int TILE_HEIGHT = 32;
    
    private final Color innerColor = Color.ALICEBLUE;
    private final Color outerColor = Color.TRANSPARENT;
    
    private int playerLocationXAxis;
    private int playerLocationYAxis;
    
    
    public Player(){
        
    }
    
    public void drawPlayer(int xAxis, int yAxis){
        this.setPlayerLocationXAxis(xAxis);
        this.setPlayerLocationYAxis(yAxis);
        
        GraphicsContext gc = GameViewController.getGraphicsContext();
        gc.setFill(getOuterColor());
        gc.fillRect(getPlayerLocationXAxis(), getPlayerLocationYAxis(), getTILE_WIDTH(), getTILE_HEIGHT());
        gc.setFill(getInnerColor());
        gc.fillRect(getPlayerLocationXAxis() + 8, getPlayerLocationYAxis() + 8, getTILE_WIDTH() - 12, getTILE_HEIGHT() - 12);
    }

    /**
     * @return the TILE_WIDTH
     */
    public int getTILE_WIDTH() {
        return TILE_WIDTH;
    }

    /**
     * @return the TILE_HEIGHT
     */
    public int getTILE_HEIGHT() {
        return TILE_HEIGHT;
    }

    /**
     * @return the innerColor
     */
    public Color getInnerColor() {
        return innerColor;
    }

    /**
     * @return the outerColor
     */
    public Color getOuterColor() {
        return outerColor;
    }

    /**
     * @return the playerLocationXAxis
     */
    public int getPlayerLocationXAxis() {
        return playerLocationXAxis;
    }

    /**
     * @param playerLocationXAxis the playerLocationXAxis to set
     */
    public void setPlayerLocationXAxis(int playerLocationXAxis) {
        this.playerLocationXAxis = playerLocationXAxis;
    }

    /**
     * @return the playerLocationYAxis
     */
    public int getPlayerLocationYAxis() {
        return playerLocationYAxis;
    }

    /**
     * @param playerLocationYAxis the playerLocationYAxis to set
     */
    public void setPlayerLocationYAxis(int playerLocationYAxis) {
        this.playerLocationYAxis = playerLocationYAxis;
    }
    
}