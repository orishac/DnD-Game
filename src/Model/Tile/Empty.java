package Model.Tile;

import Model.Tile.Units.Enemy.Enemy;
import Model.Tile.Units.Player.Player;
import Model.Tile.Units.Visitor;

public class Empty extends Tile {

    public Empty(int x, int y) {
        super('.', x, y);
    }

    public String toString(){
        return ".";
    }

    @Override
    public boolean acceptInteraction(Visitor visitor) {
        visitor.interact(this);
        return true;
    }

    @Override
    public boolean interact(Empty emptyTile) {
        return true;
    }

    @Override
    public boolean interact(Wall wall) {
        return true;
    }

    @Override
    public boolean interact(Enemy enemy) {
        return true;
    }

    @Override
    public boolean interact(Player player) {
        return true;
    }
}
