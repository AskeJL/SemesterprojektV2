package presentation.tiles;

import javafx.scene.paint.Color;

public class WallTile extends Tile{
    
    private final char SYMBOL = '+';
    
    public WallTile(){
        this.setTileType(TileType.WALL);
        this.setTileColor(Color.BROWN);
    }

    public char getSYMBOL() {
        return SYMBOL;
    }
    
}
