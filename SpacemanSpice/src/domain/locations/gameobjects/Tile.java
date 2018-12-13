package domain.locations.gameobjects;

import domain.locations.GameObject;
import domain.locations.GameObjectType;
import javafx.scene.image.Image;

/**
 * The actual tiles that are drawn on top of the canvas. Every tile is
 * identified by a symbol:{@link #symbol}, an Image:{@link #tileImage} and a
 * {@link GameObject}:{@link #gameObject}.
 */
public class Tile {

    /**
     * The symbol representing this tile.
     */
    private final char symbol;

    /**
     * The x position of this tile.
     */
    private int xPos;

    /**
     * The y position of this tile.
     */
    private int yPos;

    /**
     * Whether or not this tile is a solid object. (If solid the player can't
     * translate the tile)
     */
    private final boolean solid;

    /**
     * This tiles {@link GameObjectType}.
     */
    private final GameObjectType gameObjectType;

    /**
     * The {@link GameObject} that represents this tile.
     */
    private final GameObject gameObject;

    /**
     * The visual representation of this tile.
     */
    private final Image tileImage;

    public Tile(char symbol, Boolean isSolid, GameObjectType type, GameObject gameObject, Image img) {
        this.symbol = symbol;
        this.solid = isSolid;
        this.gameObjectType = type;
        this.gameObject = gameObject;
        this.tileImage = img;
    }

    /**
     * Set the {@link #xPos}.
     *
     * @param x The x position to set
     */
    public void setXPos(int x) {
        this.xPos = x;
    }

    /**
     * Set the {@link #yPos}.
     *
     * @param y The y position to set
     */
    public void setYPos(int y) {
        this.yPos = y;
    }

    /**
     * Get {@link #symbol}.
     *
     * @return The symbol.
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * Get the {@link #xPos}.
     *
     * @return The x position.
     */
    public int getXPos() {
        return xPos;
    }

    /**
     * Get the {@link #yPos}.
     *
     * @return The y position.
     */
    public int getYPos() {
        return yPos;
    }

    /**
     * Get {@link #solid}.
     *
     * @return Whether or not this tile is solid.
     */
    public boolean getSolid() {
        return solid;
    }

    /**
     * Get the {@link #gameObjectType}.
     *
     * @return The type of the gameObject.
     */
    public GameObjectType getGameObjectType() {
        return gameObjectType;
    }

    /**
     * Get {@link #gameObject}.
     *
     * @return The GameObject representing this tile.
     */
    public GameObject getGameObject() {
        return gameObject;
    }

    /**
     * Get {@link #tileImage}.
     *
     * @return The tile image representing this tile.
     */
    public Image getTileImage() {
        return tileImage;
    }
}
