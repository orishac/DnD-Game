package Model.Tile.Units.Player;


import Model.Board.Board;
import Model.Tile.Empty;
import Model.Tile.Units.Enemy.Enemy;
import Model.Tile.Units.HeroicUnit;
import Model.Tile.Units.Stat;
import Model.Tile.Units.Unit;
import Model.Tile.Units.Visitor;
import Model.Tile.Wall;
import View.BoardView;

public abstract class Player extends Unit implements HeroicUnit {
    protected Stat experience;
    protected Stat level;

    public Player(int x, int y, String name, int pool, int amount, int attack, int defense, Board board, BoardView view) {
        super('@',x,y, name, pool, amount, attack, defense,board, view);
        experience=new Stat(0);
        level=new Stat(1);
    }

    public void levelUp() {
        experience.setStatPoints(experience.getStatPoints()-50*level.getStatPoints());
        level.setStatPoints(level.getStatPoints()+1);
        health.setPool(health.getPool()+10*level.getStatPoints());
        health.setAmount(health.getPool());
        attack.setStatPoints(attack.getStatPoints()+4*level.getStatPoints());
        defense.setStatPoints(defense.getStatPoints()+level.getStatPoints());
    }

    public String toString(){
        return "@";
    }

    @Override
    public boolean acceptInteraction(Visitor visitor) {
        return visitor.interact(this);
    }

    @Override
    public boolean interact(Enemy enemy) {
        enterCombat(this, enemy);
        return false;
    }

    @Override
    public boolean interact(Wall wall) {
        return super.interact(wall);
    }

    @Override
    public boolean interact(Player player) {
        return false;
    }

    @Override
    public boolean interact(Empty emptyTile) {
        return super.interact(emptyTile);
    }

    public int getLevel() {
        return level.getStatPoints();
    }

    public int getExp() {
        return experience.getStatPoints();
    }

    public void removeFromBoard() {
        //need to stop game and to start over
        board.removePlayer();
    }

    public abstract void printStatus();
}

