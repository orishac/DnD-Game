package Model.Tile.Units.Enemy;

import Model.Board.Board;
import Model.Tile.Empty;
import Model.Tile.Tile;
import Model.Tile.Units.Player.Player;
import Model.Tile.Units.Unit;
import Model.Tile.Units.Visitor;
import Model.Tile.Wall;
import View.BoardView;

public abstract class Enemy extends Unit {

    private int experience;

    public Enemy(char type, int x, int y, String name, int pool, int amount , int attack , int defense, int expValue, Board board, BoardView view) {
        super(type, x, y, name, pool, amount, attack, defense, board, view);
        experience=expValue;
    }

    public abstract boolean isVisible();

    public String toString() {
        return super.toString();
    }

    @Override
    public boolean acceptInteraction(Visitor visitor) {
        return visitor.interact(this);
    }

    @Override
    public boolean interact(Empty emptyTile) {
        return super.interact(emptyTile);
    }

    @Override
    public boolean interact(Player player) {
        enterCombat(this, player);
        return false;
    }

    @Override
    public boolean interact(Wall wall) {
        return super.interact(wall);
    }

    @Override
    public boolean interact(Enemy enemy) {
        return false;
    }

    public abstract void onEnemyTurn();

    public int getExperience() {
        return experience;
    }

    @Override
    public void removeFromBoard(Unit attacker) {
        super.removeFromBoard(attacker);
        view.PrintUnitIsDead(this, attacker);
    }
}
