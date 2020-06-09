package Model.Tile.Units.Enemy;

import Model.Board.Board;
import Model.Tile.Empty;
import Model.Tile.Range;
import Model.Tile.Units.Player.Player;
import Model.Tile.Units.Visitor;
import Model.Tile.Wall;

public class Monster extends Enemy {

    private int visionRange;

    public Monster( char type, int x, int y, String name, int pool, int amount , int attack , int defense, int visionRange, Board board) {
        super (type, x, y, name, pool, amount, attack, defense, board);
    }

    @Override
    public boolean isVisible() {
        return true;
    }

    public boolean isPlayerInRange(Player myPlayer) {
        return (getRange(this, myPlayer)<visionRange);
    }

}
