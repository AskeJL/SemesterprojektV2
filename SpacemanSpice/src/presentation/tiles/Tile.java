package presentation.tiles;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import presentation.game.GameViewController;

public class Tile {

    private final int TILE_WIDTH = 32;
    private final int TILE_HEIGHT = 32;
    private TileType tileType;
    private int tileLocationXAxis;
    private int tileLocationYAxis;
    private Color tileColor;
    private final char SYMBOL;
    
    /**
     * 
     * @param type
     * @param color
     * @param symbol 
     */
    public Tile(TileType type, Color color, char symbol){
        
        this.tileType = type;
        this.tileColor = color;
        this.SYMBOL = symbol;
        
    }
    
    
    

    public void drawTile(int xAxis, int yAxis) {
        this.tileLocationXAxis = xAxis;
        this.tileLocationYAxis = yAxis;
        GraphicsContext gc = GameViewController.getGraphicsContext();
        gc.setFill(Color.TRANSPARENT);
        gc.fillRect(tileLocationXAxis, tileLocationYAxis, TILE_WIDTH, TILE_HEIGHT);
        gc.setFill(getTileColor());
        gc.fillRect(tileLocationXAxis + 2, tileLocationYAxis + 2, TILE_WIDTH - 2, TILE_HEIGHT - 2);
       
        
    }

    public int getTILE_WIDTH() {
        return TILE_WIDTH;
    }

    public int getTILE_HEIGHT() {
        return TILE_HEIGHT;
    }

    public TileType getTileType() {
        return tileType;
    }

    public int getTileLocationXAxis() {
        return tileLocationXAxis;
    }

    public int getTileLocationYAxis() {
        return tileLocationYAxis;
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }

    public void setTileLocationXAxis(int tileLocationXAxis) {
        this.tileLocationXAxis = tileLocationXAxis;
    }

    public void setTileLocationYAxis(int tileLocationYAxis) {
        this.tileLocationYAxis = tileLocationYAxis;
    }

    public Color getTileColor() {
        return tileColor;
    }

    public void setTileColor(Color tileColor) {
        this.tileColor = tileColor;
    }

    /**
     * @return the SYMBOL
     */
    public char getSYMBOL() {
        return SYMBOL;
    }
}
