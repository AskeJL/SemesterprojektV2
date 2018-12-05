
package presentation.player;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import presentation.controllers.ViewController_Game;

/**
 * Player class with following attributes:
 * Size: width, height
 * Color: inner color, outer color
 * Location, x axis, y axis
 * 
 */
public class Player {
    
    private final int TILE_WIDTH = 32;
    private final int TILE_HEIGHT = 32;
    
    private final Color innerColor = Color.TRANSPARENT;
    private final Color outerColor = Color.TRANSPARENT;
    
    private final Image playerImage = new Image(getClass().getResourceAsStream("spacemanSpice.png"));
    
    private int playerLocationXAxis;
    private int playerLocationYAxis;
    
    private final ViewController_Game gameViewController;
    
    public Player(ViewController_Game controller){
        this.gameViewController = controller;
    }
    
    /**
     * Method that draws the player on the canvas, based on its location on the x/y axis.
     * @param xAxis
     * @param yAxis 
     */
    public void drawPlayer(int xAxis, int yAxis){
        this.setPlayerLocationXAxis(xAxis);
        this.setPlayerLocationYAxis(yAxis);
        
        GraphicsContext gc = gameViewController.getGraphicsContext();
        gc.setFill(getOuterColor());
        gc.fillRect(getPlayerLocationXAxis(), getPlayerLocationYAxis(), getTILE_WIDTH(), getTILE_HEIGHT());
        gc.setFill(getInnerColor());
        gc.fillRect(getPlayerLocationXAxis() + 8, getPlayerLocationYAxis() + 8, getTILE_WIDTH() - 12, getTILE_HEIGHT() - 12);
        gc.drawImage(playerImage, xAxis, yAxis);
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