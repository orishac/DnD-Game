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

    public void onEnemyTurn()
    {
        if(board.rangeFromPlayer(this)<visionRange)
        {
            int dx=board.getXDifferenceFromPlayer(this);
            int dy=board.getYDifferenceFromPlayer(this);
            if(Math.abs(dx)>Math.abs(dy)) {
                if(dx>0)
                    moveLeft();
                else
                    moveRight();
            }
            else {
                if(dy>0)
                    moveUp();
                else
                    moveDown();
            }
        }
        else
        {

        }
    }
}
