package Model.Tile.Units;
import Model.Board.Board;
import Model.Tile.Tile;
import Model.Tile.Units.Enemy.Monster;

public abstract class Unit extends Tile {

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
            //need to update board
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

    public boolean isAlive() {
        return getHealthAmount()>0;
    }

    public String getName(){
        return name;
    }

    /*TO DO: public void interact(Monster m);
      public void interact(Empty e);
      public void interact(Player p);
      public void interact(Wall w);
     */
}

