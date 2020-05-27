package Model.Tile.Units.Player;

import Model.Board.Board;

public class Mage extends Player {

    private int manaPool;
    private int currentMana;
    private int manaCost;
    private int spellPower;
    private int hitsCount;
    private int abilityRange;

    public Mage(int x, int y, String name, int pool, int amount, int attack, int defense, Board board) {
        super(x, y, name, pool, amount, attack, defense, board);
    }

    public void levelUp() {
        super.levelUp();
        manaPool = manaPool + (25 * level);
        currentMana = (getMin(currentMana+ (manaPool/4), manaPool));
        spellPower = spellPower + (10 * level);

    }

    @Override
    public void castSpecialAbility() {

    }

    private int getMin (int a, int b) {
        if (a>b)
            return b;
        return a;
    }
}
