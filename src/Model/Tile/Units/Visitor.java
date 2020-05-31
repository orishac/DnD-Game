package Model.Tile.Units;

import Model.Tile.Empty;
import Model.Tile.Units.Enemy.Enemy;
import Model.Tile.Units.Player.Player;
import Model.Tile.Wall;

public interface Visitor {
    public void interact(Empty emptyTile);
    public void interact(Wall wall);
    public void interact(Enemy enemy);
    public void interact(Player player);
}
