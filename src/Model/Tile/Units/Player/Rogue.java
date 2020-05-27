package Model.Tile.Units.Player;

import Model.Board.Board;

public class Rogue extends Player {

    private int cost;
    private int currentEnergy;

    public Rogue(int x, int y, String name, int pool, int amount, int attack, int defense, Board board) {
        super(x, y, name, pool, amount, attack, defense, board);
        currentEnergy = 100;
    }

    public void levelUp() {
        super.levelUp();
        currentEnergy = 100;
        attackPoints = attackPoints + (3 * level);
    }

    @Override
    public void castSpecialAbility() {

    }
}
