package Model.Tile.Units.Player;

import Model.Board.Board;
import Model.Tile.Units.Enemy.Enemy;
import Model.Tile.Units.Enemy.Monster;
import Model.Tile.Units.HeroicUnit;
import Model.Tile.Units.Resource;
import Model.Tile.Units.Stat;
import Model.Tile.Units.Visitor;
import View.BoardView;

import java.util.Random;
import java.util.List;

public class Mage extends Player implements HeroicUnit {

    private Resource mana;
    private Stat manaCost;
    private Stat spellPower;
    private Stat hitsCount;
    private Stat abilityRange;

    public Mage(int x, int y, String name, int pool, int amount, int attack, int defense, int mana , int spellPower,
                int manaCost, int hitCount, int range, Board board, BoardView view) {
        super(x, y, name, pool, amount, attack, defense, board, view);
        this.mana=new Resource(mana, mana/4);
        this.spellPower = new Stat(spellPower);
        this.manaCost = new Stat(manaCost);
        this.hitsCount = new Stat(hitCount);
        this.abilityRange = new Stat(range);

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
            view.abilityError();
        }
        else {
            mana.setAmount(mana.getAmount()-manaCost.getStatPoints());
            int hits=0;
            Random rndGenerator=new Random();
            int monsterDefense = 0;
            List<Enemy> monsterList=board.getMonstersInRange(abilityRange.getStatPoints());
            while(hits<hitsCount.getStatPoints()&monsterList.size()>0) {
                int randomIndex=rndGenerator.nextInt(monsterList.size());
                Enemy monster=monsterList.get(randomIndex);
                monsterDefense=rndGenerator.nextInt(monster.getDefensePoints()+1);
                int damage=spellPower.getStatPoints()-monsterDefense;
                if(damage>0) {
                    monster.setHealthAmount(monster.getHealthAmount()-damage);
                    monsterList=board.getLivingMosters(monsterList);
                    view.printMageSpecialAbility(this, monster, monsterDefense, damage);
                }
                hits++;
            }
        }
    }

    @Override
    public boolean acceptInteraction(Visitor visitor) {
        return visitor.interact(this);
    }

    @Override
    public void printStatus() {
        view.printMageStatus(this.name, this.health, this.attack, this.defense, this.level, this.experience, this.mana, this.spellPower);
    }
}
