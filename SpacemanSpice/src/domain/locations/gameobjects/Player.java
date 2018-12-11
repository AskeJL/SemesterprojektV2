package domain.locations.gameobjects;

import java.io.File;
import javafx.scene.image.Image;

/**
 * Player game object, used in GUI mode.
 * 
 */
public class Player {
    
    private int xPosition;
    private int yPosition;
    
    private final Image playerImage;
            
    public Player(){
        playerImage = new Image(new File("assets/pictures/spacemanSpice.png").toURI().toString());
    }

    /**
     * @return the xPosition
     */
    public int getxPosition() {
        return xPosition;
    }

    /**
     * @param xPosition the xPosition to set
     */
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    /**
     * @return the yPosition
     */
    public int getyPosition() {
        return yPosition;
    }

    /**
     * @param yPosition the yPosition to set
     */
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    /**
     * @return the playerImage
     */
    public Image getPlayerImage() {
        return playerImage;
    }
}
