package presentation.tiles;

import javafx.scene.paint.Color;

public class WestExitTile extends Tile {
    
    private final char SYMBOL = 'W';
    
    public WestExitTile(){
        this.setTileType(TileType.WEST_EXIT);
        this.setTileColor(Color.GREEN);
    }

    public char getSYMBOL() {
        return SYMBOL;
    }
}
