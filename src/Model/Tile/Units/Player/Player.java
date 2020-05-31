package Model.Tile.Units.Player;


import Model.Board.Board;
import Model.Tile.Units.Stat;
import Model.Tile.Units.Unit;

public abstract class Player extends Unit {
    protected Stat experience;
    protected Stat level;

    public Player(int x, int y, String name, int pool, int amount, int attack, int defense,Board board) {
        super('@',x,y, name, pool, amount, attack, defense,board);
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

    public abstract void castSpecialAbility();
}

