package presentation.tiles;

import javafx.scene.paint.Color;

public class ConsoleTile extends Tile{
    
    private final char SYMBOL = '-';

    public ConsoleTile() {
        this.setTileType(TileType.CONSOLE);
        this.setTileColor(Color.RED);
    }

    public char getSYMBOL() {
        return SYMBOL;
    }
}
