package presentation.player;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import presentation.controllers.ViewController_Game;

/**
 * Player class with following attributes: Size: width, height Color: inner
 * color, outer color Location, x axis, y axis
 *
 */
public class Player {

    private final int TILE_WIDTH = 32;
    private final int TILE_HEIGHT = 32;

    private final Color innerColor = Color.TRANSPARENT;
    private final Color outerColor = Color.TRANSPARENT;

    private final Image playerImage = new Image(getClass().getResourceAsStream("spacemanSpice.png"));

    private int xPos;
    private int yPos;

    private final ViewController_Game gameViewController;

    public Player(ViewController_Game controller) {
        this.gameViewController = controller;
    }

    /**
     * Method that draws the player on the canvas, based on its location on the
     * x/y axis.
     *
     * @param x
     * @param y
     */
    public void drawPlayer(int x, int y) {
        this.setXPos(x);
        this.setYPos(y);

        GraphicsContext gc = gameViewController.getGraphicsContext();
        gc.setFill(getOuterColor());
        gc.fillRect(getXPos(), getYPos(), getTILE_WIDTH(), getTILE_HEIGHT());
        gc.setFill(getInnerColor());
        gc.fillRect(getXPos() + 8, getYPos() + 8, getTILE_WIDTH() - 12, getTILE_HEIGHT() - 12);
        gc.drawImage(playerImage, x, y);
    }

    /**
     * @param xPos the playerLocationXAxis to set
     */
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * @param yPos the playerLocationYAxis to set
     */
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * @return the playerLocationXAxis
     */
    public int getXPos() {
        return xPos;
    }

    /**
     * @return the playerLocationYAxis
     */
    public int getYPos() {
        return yPos;
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
}
