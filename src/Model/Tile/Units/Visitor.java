package Model.Tile.Units;

import Model.Tile.Empty;
import Model.Tile.Tile;
import Model.Tile.Units.Enemy.Enemy;
import Model.Tile.Units.Player.Player;
import Model.Tile.Wall;

public interface Visitor {
    public boolean interact(Empty emptyTile);
    public boolean interact(Wall wall);
    public boolean interact(Enemy enemy);
    public boolean interact(Player player);
}
