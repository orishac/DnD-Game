package Model.Tile;

import Model.Tile.Units.Enemy.Enemy;
import Model.Tile.Units.Enemy.Trap;
import Model.Tile.Units.Player.Player;
import Model.Tile.Units.Visitor;

public class Wall extends Tile {


    public Wall( int x, int y) {
        super('#', x, y);
    }

    public String toString(){
        return "#";
    }

    @Override
    public boolean acceptInteraction(Visitor visitor) {
        return visitor.interact(this);
    }

    @Override
    public boolean interact(Empty emptyTile) {
        return false;
    }

    @Override
    public boolean interact(Wall wall) {
        return false;
    }

    @Override
    public boolean interact(Enemy enemy) {
        return false;
    }

    @Override
    public boolean interact(Player player) {
        return false;
    }

    public boolean interact(Trap trap) {
        return false;
    }
}
