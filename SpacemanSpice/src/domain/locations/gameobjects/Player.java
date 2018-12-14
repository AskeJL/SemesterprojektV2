package domain.locations.gameobjects;

import java.io.File;
import javafx.scene.image.Image;

/**
 * Player game object, used in GUI mode.
 *
 */
public class Player {

    /**
     * The x position of the player.
     */
    private int xPosition;

    /**
     * The y position of the player.
     */
    private int yPosition;

    /**
     * The image of Spaceman Spice.
     */
    private final Image playerImage;

    public Player() {
        playerImage = new Image(new File("assets/pictures/spacemanSpice.png").toURI().toString());
    }

    /**
     * Set the {@link #xPosition}.
     * 
     * @param xPosition the xPosition to set
     */
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    /**
     * Set the {@link #yPosition}.
     * 
     * @param yPosition the yPosition to set
     */
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    /**
     * Get the {@link #xPosition}.
     *
     * @return the xPosition
     */
    public int getxPosition() {
        return xPosition;
    }

    /**
     * Get the {@link #yPosition}.
     * 
     * @return the yPosition
     */
    public int getyPosition() {
        return yPosition;
    }

    /**
     * Get the {@link #playerImage}.
     * 
     * @return the playerImage
     */
    public Image getPlayerImage() {
        return playerImage;
    }
}
