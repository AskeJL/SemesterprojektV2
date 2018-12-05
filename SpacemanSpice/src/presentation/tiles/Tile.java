package presentation.tiles;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import presentation.controllers.GameViewController;

/**
 * Class Tile, 
 * creates the basic layout of all tiles that can be implemented.
 */
public class Tile {

    private final int TILE_WIDTH = 32;
    private final int TILE_HEIGHT = 32;
    private TileType tileType;
    private int tileLocationXAxis;
    private int tileLocationYAxis;
    private Color tileColor;
    private final char SYMBOL;
    private final Boolean solid; 
    private final Enum interactableType;
    private final Direction direction;
    private final Image tileImage;
   
    private final GraphicsContext gc;
    
    /**
     * Tile constructor
     * @param gc
     * @param type
     * @param color
     * @param symbol 
     * @param newImage 
     * @param isSolid 
     * @param canInteractType 
     * @param newDirection 
     */
    public Tile(GraphicsContext gc, TileType type, Color color, char symbol, Image newImage, Boolean isSolid, Enum canInteractType, Direction newDirection){
        this.gc = gc;
        this.tileType = type;
        this.tileColor = color;
        this.SYMBOL = symbol;
        this.tileImage = newImage;
        this.solid = isSolid;
        this.interactableType = canInteractType;
        this.direction = newDirection;
        
    }
    
    
    
    /**
     * Draws a tile on the corresponding x and y axis.
     * @param img
     * @param xAxis
     * @param yAxis 
     */
    public void drawTile(Image img, int xAxis, int yAxis) {
        this.tileLocationXAxis = xAxis;
        this.tileLocationYAxis = yAxis;
        //gc.setFill(Color.TRANSPARENT);
        //gc.fillRect(tileLocationXAxis, tileLocationYAxis, TILE_WIDTH, TILE_HEIGHT);
        //gc.setFill(getTileColor());
        //gc.fillRect(tileLocationXAxis + 2, tileLocationYAxis + 2, TILE_WIDTH - 2, TILE_HEIGHT - 2);
        gc.drawImage(img, xAxis, yAxis);
       
        
    }
    /**
     * 
     * @return TILE_WIDTH 
     */
    public int getTILE_WIDTH() {
        return TILE_WIDTH;
    }

    /**
     * 
     * @return TILE_HEIGHT
     */
    public int getTILE_HEIGHT() {
        return TILE_HEIGHT;
    }

    /**
     * 
     * @return tileType
     */
    public TileType getTileType() {
        return tileType;
    }

    /**
     * 
     * @return tileLocationXAxis
     */
    public int getTileLocationXAxis() {
        return tileLocationXAxis;
    }

    /**
     * 
     * @return tileLocationYAxis
     */
    public int getTileLocationYAxis() {
        return tileLocationYAxis;
    }

    /**
     * This method can be used to change the tile type of a tie.
     * @param tileType 
     */
    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    /**
     * sets the tile location at the x axis
     * @param tileLocationXAxis 
     */
    public void setTileLocationXAxis(int tileLocationXAxis) {
        this.tileLocationXAxis = tileLocationXAxis;
    }

    /**
     * sets the tile location at the x axis
     * @param tileLocationYAxis 
     */
    public void setTileLocationYAxis(int tileLocationYAxis) {
        this.tileLocationYAxis = tileLocationYAxis;
    }

    public Color getTileColor() {
        return tileColor;
    }

    /**
     * Sets the color of the tile.
     * @param tileColor 
     */
    public void setTileColor(Color tileColor) {
        this.tileColor = tileColor;
    }

    /**
     * @return the SYMBOL
     */
    public char getSYMBOL() {
        return SYMBOL;
    }

    /**
     * @return the solid
     */
    public Boolean getSolid() {
        return solid;
    }

    /**
     * @return the interactableType
     */
    public Enum getInteractableType() {
        return interactableType;
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @return the tileImage
     */
    public Image getTileImage() {
        return tileImage;
    }

    
}
