package Model.Tile.Units;
import Model.Board.Board;
import Model.Tile.Empty;
import Model.Tile.Position;
import Model.Tile.Tile;
import Model.Tile.Units.Enemy.Enemy;
import Model.Tile.Units.Player.Player;
import Model.Tile.Wall;
import View.BoardView;

import java.util.Random;

public abstract class Unit extends Tile implements Visitor, Visited {
//need to make another enterCombat: one for when the attack amount is random and one for when it isn't.
    protected String name;
    protected Resource health;
    protected Stat defense;
    protected Stat attack;
    protected Board board;
    protected BoardView view;

    public Unit(char type, int x, int y, String name, int pool, int amount, int attack, int defense, Board board, BoardView view) {
        super(type, x, y);
        this.name = name;
        this.health = new Resource(pool, amount);
        this.attack = new Stat(attack);
        this.defense = new Stat(defense);
        this.board = board;
        this.view=view;
    }

    public void setHealthPool(int pool) {
        health.setPool(pool);
    }

    public void setHealthAmount(int newHealth) {
        health.setAmount(newHealth);
        if(health.getAmount()==0) {
            removeFromBoard(this);
        }
    }

    public void setAttackPoints(int attack) {
        this.attack.setStatPoints(attack);
    }

    public void setDefensePoints(int defense) {
        this.defense.setStatPoints(defense);
    }

    public int getHealthAmount() {
        return health.getAmount();
    }

    public int getHealthPool() {
        return health.getPool();
    }

    public int getDefensePoints() {
        return defense.getStatPoints();
    }

    public int getAttackPoints() {
        return attack.getStatPoints();
    }

    public boolean isAlive() {
        return getHealthAmount() > 0;
    }

    public String getName() {
        return name;
    }

    public boolean interact(Empty emptyTile) {
        return true;
    }

    public boolean interact(Wall wall) {
        //do nothing,the unit can't move(generate a message?)
        return false;
    }

    public boolean interact(Enemy enemy) {
        enterCombat(this, enemy);
        return false;
    }

    public boolean interact(Player player) {
        enterCombat(this, player);
        return false;
    }


    public boolean interaction(Tile tile) {
        return tile.acceptInteraction(this);
    }

    public void enterCombat(Unit attacker, Unit defender) {
        Random rnd = new Random();
        int attack = rnd.nextInt(attacker.getAttackPoints() + 1);
        int defense = rnd.nextInt(defender.getDefensePoints() + 1);
        int damage = attack - defense;
        if (damage > 0) {
            defender.setHealthAmount(defender.getHealthAmount() - damage);
        }
        view.PrintCombatView(attacker,defender,attack,defense,damage);
        if (defender.getHealthAmount()<=0) {
            defender.removeFromBoard(attacker);
        }
    }


    public void moveUp() {
        if (interaction(board.above(this))) {
            board.switchPlaces(this, board.above(this));
        }
    }

    public void moveDown() {
        if (interaction(board.below(this))) {
            board.switchPlaces(this, board.below(this));
        }
    }

    public void moveLeft() {
        if (interaction(board.onLeft(this))) {
            board.switchPlaces(this, board.onLeft(this));
        }
    }

    public void moveRight() {
        if (interaction(board.onRight(this))) {
            board.switchPlaces(this, board.onRight(this));
        }
    }

    public void removeFromBoard(Unit attacker) {
        Position toBeRemoved = this.getPosition();
        int x = toBeRemoved.getxCord();
        int y = toBeRemoved.getyCord();
        board.removeUnit(this, x,y);
    }

    public abstract void expUp(int expPoints);
}


