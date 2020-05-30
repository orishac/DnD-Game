package Model.Tile.Units.Player;

import Model.Board.Board;
import Model.Tile.Units.Enemy.Monster;
import Model.Tile.Units.Resource;
import Model.Tile.Units.Stat;
import java.util.Random;
import java.util.List;

public class Mage extends Player {

    private Resource mana;
    private Stat manaCost;
    private Stat spellPower;
    private Stat hitsCount;
    private Stat abilityRange;

    public Mage(int x, int y, String name, int pool, int amount, int attack, int defense, Board board) {
        super(x, y, name, pool, amount, attack, defense, board);
    }

    public void levelUp() {
        super.levelUp();
        mana.setPool(mana.getPool()+25*level.getStatPoints());
        mana.setAmount(Math.min(mana.getAmount()+mana.getPool()/4,mana.getPool()));
        spellPower.setStatPoints(spellPower.getStatPoints()+10*level.getStatPoints());
    }

    @Override
    public void castSpecialAbility() {
        if(mana.getAmount()<manaCost.getStatPoints()) {
            //need to generate an error message
        }
        else {
            mana.setAmount(mana.getAmount()-manaCost.getStatPoints());
            int hits=0;
            Random rndGenerator=new Random();
            List<Monster> monsterList=board.getMonstersInRange(abilityRange.getStatPoints());
            while(hits<hitsCount.getStatPoints()&monsterList.size()>0) {
                int randomIndex=rndGenerator.nextInt(monsterList.size());
                Monster monster=monsterList.get(randomIndex);
                int defense=rndGenerator.nextInt(monster.getDefensePoints()+1);
                int damage=spellPower.getStatPoints()-defense;
                if(damage>0) {
                    monster.setHealthAmount(monster.getHealthAmount()-damage);
                    monsterList=board.getLivingMosters(monsterList);
                }
                hits++;
            }
        }
    }

}
