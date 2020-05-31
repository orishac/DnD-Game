package Model.Tile.Units;
import Model.Board.Board;
import Model.Tile.Empty;
import Model.Tile.Tile;
import Model.Tile.Units.Enemy.Enemy;
import Model.Tile.Units.Player.Player;
import Model.Tile.Wall;
import java.util.Random;

public abstract class Unit extends Tile implements Visitor{

    protected String name;
    protected Resource health;
    protected Stat defense;
    protected Stat attack;
    protected Board board;

    public Unit (char type, int x, int y, String name, int pool, int amount, int attack , int defense,Board board ) {
        super(type,x,y);
        this.name= name;
        this.health=new Resource(pool,amount);
        this.attack=new Stat(attack);
        this.defense=new Stat(defense);
        this.board=board;
    }

    public void setHealthPool(int pool){
        health.setPool(pool);
    }

    public void setHealthAmount(int newHealth){
        health.setAmount(newHealth);
        if(health.getAmount()==0) {
            //need to remove this unit from the board.
        }
    }

    public void setAttackPoints(int attack){
        this.attack.setStatPoints(attack);
    }

    public void setDefensePoints(int defense){
        this.defense.setStatPoints(defense);
    }

    public int getHealthAmount(){
        return health.getAmount();
    }

    public int getDefensePoints() {
        return defense.getStatPoints();
    }

    public int getAttackPoints() { return attack.getStatPoints(); }

    public boolean isAlive() {
        return getHealthAmount()>0;
    }

    public String getName(){
        return name;
    }

    public void interact(Empty emptyTile) {
        board.switchPlaces(this,emptyTile);
    }

    public void interact(Wall wall) {
        //do nothing,the unit can't move(generate a message?)
    }

    public void interact(Enemy enemy) {
        enterCombat(this,enemy);
    }

    public void interact(Player player) {
        enterCombat(this,player);
    }

    public void interaction(Tile tile) {
        tile.acceptInteraction(this);
    }

    public void enterCombat(Unit attacker, Unit defender) {
        Random rnd=new Random();
        int attack=rnd.nextInt(attacker.getAttackPoints()+1);
        int defense=rnd.nextInt(defender.getDefensePoints()+1);
        int damage=attack-defense;
        if(damage>0) {
            defender.setHealthAmount(defender.getHealthAmount()-damage);
        }
    }

    public void moveUp() {
        //if can move up interact with tile above
    }

    public void moveDown() {
        //if can move down interact with tile below
    }

    public void moveLeft() {
        //if can move left interact with tile on the left
    }

    public void moveRight() {
        //if can move right interact with tile on the right
    }
}

