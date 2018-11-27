package presentation.tiles;

import javafx.scene.paint.Color;

public class NorthExitTile extends Tile {
    
    private final char SYMBOL = 'N';
    
    public NorthExitTile(){
        this.setTileType(TileType.NORTH_EXIT);
        this.setTileColor(Color.DARKCYAN);
    }

    public char getSYMBOL() {
        return SYMBOL;
    }
    
}
