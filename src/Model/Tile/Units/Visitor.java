package Model.Tile.Units;

import Model.Tile.Empty;
import Model.Tile.Units.Enemy.Enemy;
import Model.Tile.Units.Player.Player;
import Model.Tile.Wall;

public interface Visitor {
     boolean interact(Empty emptyTile);
     boolean interact(Wall wall);
     boolean interact(Enemy enemy);
     boolean interact(Player player);
}
