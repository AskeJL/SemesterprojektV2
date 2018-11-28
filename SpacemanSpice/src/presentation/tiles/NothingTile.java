
package presentation.tiles;

import javafx.scene.paint.Color;


public class NothingTile extends Tile{
    
    private final char SYMBOL = ' ';
    
    public NothingTile(){
        this.setTileColor(Color.TRANSPARENT);
        this.setTileType(TileType.NOTHING);
    }

    /**
     * @return the SYMBOL
     */
    public char getSYMBOL() {
        return SYMBOL;
    }
}
