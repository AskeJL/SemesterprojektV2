
package presentation.tiles;

import javafx.scene.paint.Color;

public class EastExitTile extends Tile {
    
    private final char SYMBOL = 'E';
    
    public EastExitTile(){
        this.setTileType(TileType.EAST_EXIT);
        this.setTileColor(Color.YELLOW);
    }

    public char getSYMBOL() {
        return SYMBOL;
    }
    
}
