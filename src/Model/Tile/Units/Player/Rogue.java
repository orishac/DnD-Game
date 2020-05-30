package Model.Tile.Units.Player;

import Model.Board.Board;
import Model.Tile.Units.Enemy.Monster;
import Model.Tile.Units.Stat;

import java.util.List;
import java.util.Random;

public class Rogue extends Player {

    private Stat cost;
    private Stat currentEnergy;

    public Rogue(int x, int y, String name, int pool, int amount, int attack, int defense, int cost, Board board) {
        super(x, y, name, pool, amount, attack, defense,board);
        this.cost=new Stat(cost);
        this.currentEnergy=new Stat(100);
    }

    public void levelUp() {
        super.levelUp();
        currentEnergy.setStatPoints(100);
        setAttackPoints(attack.getStatPoints()+3*level.getStatPoints());
    }

    @Override
    public void castSpecialAbility() {
        if(currentEnergy.getStatPoints()<cost.getStatPoints()) {
            //need to generate an error message
        }
        else {
            currentEnergy.setStatPoints(currentEnergy.getStatPoints()-cost.getStatPoints());
            List<Monster>  monsterList=board.getMonstersInRange(2);
            Random rndGenerator=new Random();
            for (Monster m:monsterList )
             {
                int defense=rndGenerator.nextInt(m.getDefensePoints()+1);
                int damage=attack.getStatPoints()-defense;
                if(damage>0) {
                    m.setHealthAmount(m.getHealthAmount()-damage);
                }
             }
        }
    }
}