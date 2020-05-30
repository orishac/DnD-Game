package Model.Tile.Units.Enemy;

import Model.Board.Board;

public class Monster extends Enemy {

    private int visionRange;

    public Monster( char type, int x, int y, String name, int pool, int amount , int attack , int defense, int visionRange, Board board) {
        super (type, x, y, name, pool, amount, attack, defense, board);
    }

}