package Model.Tile.Units.Enemy;

import Model.Board.Board;
import Model.Tile.Tile;
import Model.Tile.Units.Unit;

public abstract class Enemy extends Unit {

    private int experience;

    public Enemy( char type, int x, int y, String name, int pool, int amount , int attack , int defense, Board board) {
        super(type, x, y, name, pool, amount, attack, defense, board);
    }

    public abstract boolean isVisible();

    public String toString() {
        return super.toString();
    }
}
