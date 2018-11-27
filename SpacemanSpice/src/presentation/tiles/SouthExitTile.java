package presentation.tiles;

import javafx.scene.paint.Color;

public class SouthExitTile extends Tile {

    private final char SYMBOL = 'S';
    
    public SouthExitTile(){
        this.setTileType(TileType.SOUTH_EXIT);
        this.setTileColor(Color.GREY);
    }

    public char getSYMBOL() {
        return SYMBOL;
    }
}
