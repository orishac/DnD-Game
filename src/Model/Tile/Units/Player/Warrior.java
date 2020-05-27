package Model.Tile.Units.Player;

import Model.Board.Board;

public class Warrior extends Player {

    private int abilityCooldown;
    private int remainingCooldown;


    public Warrior(int x, int y, String name, int pool, int amount, int attack, int defense, Board board) {
        super(x, y ,name, pool, amount, attack, defense, board);
        remainingCooldown = 0;
    }

    public void levelUp() {
        super.levelUp();
        remainingCooldown = 0;
        setHealthPool(healthPool + (5 * level));
        setAttackPoints(attackPoints + (2 * level));
        setDefensePoints(defensePoints + (1 * level));
    }

    @Override
    public void castSpecialAbility() {

    }

    public void abilityCast() {
        if (remainingCooldown > 0);
            //throw new Exception("there is still remaining Cooldown");
        else {
            remainingCooldown = abilityCooldown;
            healthAmount = getMin(healthAmount + (10 * defensePoints), healthPool);
           // -Randomly hits one enemy within range< 3 for an amount equals to 10 % of the warrior’s
            //health pool
        }
    }
    private int getMin (int a, int b) {
        if (a > b)
            return b;
        return a;
    }
}
