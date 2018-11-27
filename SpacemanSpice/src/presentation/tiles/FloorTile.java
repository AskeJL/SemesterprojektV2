package presentation.tiles;

import javafx.scene.paint.Color;

public class FloorTile extends Tile {

    private final char SYMBOL = '.';
    
    public FloorTile(){
        this.setTileType(TileType.FLOOR);
        this.setTileColor(Color.AQUA);
    }

    public char getSYMBOL() {
        return SYMBOL;
    }
       
    
}
