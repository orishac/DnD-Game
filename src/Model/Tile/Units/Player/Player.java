package Model.Tile.Units.Player;


import Model.Board.Board;
import Model.Tile.Units.Unit;

public abstract class Player extends Unit {
    protected int experience;
    protected int level;

    public Player(int x, int y, String name, int pool, int amount, int attack, int defense, Board board) {
        super('@',x,y, name, pool, amount, attack, defense, board);
        experience=0;
        level=1;
    }

    public void levelUp() {
        experience = experience - (50 * level);
        level = level+1;
        healthPool = healthPool + (10 * level);
        healthAmount = healthPool;
        attackPoints = attackPoints + (4 * level);
        defensePoints = defensePoints + (1 * level);

    }

    public String toString(){
        return "@";
    }


    public abstract void castSpecialAbility();
}
