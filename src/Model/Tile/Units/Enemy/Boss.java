package Model.Tile.Units.Enemy;

import Model.Board.Board;
import Model.Tile.Units.HeroicUnit;
import Model.Tile.Units.Stat;
import View.BoardView;

public class Boss extends Monster implements HeroicUnit {
    private Stat visionRange;
    private Stat abilityFrequency;
    private Stat combatTicks;

    public Boss(char type, int x, int y, String name, int pool, int amount , int attack , int defense, Board board, int range, int abilityFreq,
                int expValue, BoardView view) {
        super(type,x,y,name,pool,amount,attack,defense,range,expValue, board, view);
        this.abilityFrequency=new Stat(abilityFreq);
        combatTicks=new Stat(0);
    }

    @Override
    public void onEnemyTurn() {
        if(board.rangeFromPlayer(this)<visionRange.getStatPoints()) {
            if(combatTicks.getStatPoints()==abilityFrequency.getStatPoints()) {
                combatTicks.setStatPoints(0);
                castSpecialAbility();
            }
            else {
                combatTicks.setStatPoints(combatTicks.getStatPoints()+1);
                int dx=board.getXDifferenceFromPlayer(this);
                int dy=board.getYDifferenceFromPlayer(this);
                if(Math.abs(dx)>Math.abs(dy)) {
                    if(dy>0)
                        moveLeft();
                    else
                        moveRight();
                }
                else {
                    if(dx>0)
                        moveUp();
                    else
                        moveDown();
                }
            }
        }
        else {
            combatTicks.setStatPoints(0);
            makeRandomMovement();
        }
    }

    @Override
    public void castSpecialAbility() {
       interaction(board.getPlayer());
    }
}
