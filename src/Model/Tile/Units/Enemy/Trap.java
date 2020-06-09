package Model.Tile.Units.Enemy;

import Model.Board.Board;
import Model.Tile.Units.Visitor;

public class Trap extends Enemy {

    private int visibilityTime;
    private int invisibilityTime;
    private int ticksCount;
    private boolean visible;


    public Trap(char type, int x, int y, String name, int pool, int amount, int attack, int defense,  Board board, int visibilityTime,
                int invisibilityTime) {
        super(type, x, y, name, pool, amount , attack , defense, board);
        this.visibilityTime=visibilityTime;
        this.invisibilityTime=invisibilityTime;
        ticksCount = 0;
        visible =false;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public boolean acceptInteraction(Visitor visitor) {
        return visitor.interact(this);
    }

}
