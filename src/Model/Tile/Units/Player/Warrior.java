package Model.Tile.Units.Player;

import Model.Board.Board;
import Model.Tile.Units.Enemy.Monster;
import Model.Tile.Units.Stat;
import Model.Tile.Units.Visitor;

import java.util.Random;

import java.util.List;

public class Warrior extends Player {

    private Stat abilityCooldown;
    private Stat remainingCooldown;


    public Warrior(int x, int y, String name, int pool, int amount, int attack, int defense, int cooldown, Board board) {
        super(x, y ,name, pool, amount, attack, defense,board);
        abilityCooldown=new Stat(cooldown);
        remainingCooldown=new Stat(0);
    }

    public void levelUp() {
        super.levelUp();
        remainingCooldown.setStatPoints(0);
        setHealthPool(health.getPool() + (5 * level.getStatPoints()));
        setAttackPoints(attack.getStatPoints() + (2 * level.getStatPoints()));
        setDefensePoints(defense.getStatPoints() + (level.getStatPoints()));
    }

    @Override
    public void castSpecialAbility() {
        if(remainingCooldown.getStatPoints()>0) {
            //need to generate an error message.
        }
        else {
            remainingCooldown.setStatPoints(abilityCooldown.getStatPoints());
            health.setAmount(Math.min(health.getAmount()+10*defense.getStatPoints(),health.getPool()));
            List<Monster> inRangeOf3=board.getMonstersInRange(3);
            Random rndGenerator=new Random();
            int randomIndex=rndGenerator.nextInt(inRangeOf3.size());
            Monster randomMonster=inRangeOf3.get(randomIndex);
            randomMonster.setHealthAmount(randomMonster.getHealthAmount()-getHealthAmount()/10);
            setHealthAmount(getHealthAmount()+10*defense.getStatPoints());
        }
    }

    @Override
    public boolean acceptInteraction(Visitor visitor) {
        return visitor.interact(this);
    }

    public int getAbilityCooldown() {
        return abilityCooldown.getStatPoints();
    }

    public int getRemainingCooldown() {
        return remainingCooldown.getStatPoints();
    }
}
