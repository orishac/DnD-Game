package Model.Tile.Units;

import Model.Board.Board;
import Model.Tile.Tile;

public abstract class Unit extends Tile {

    protected String name;
    protected int healthPool;
    protected int healthAmount;
    protected int attackPoints;
    protected int defensePoints;
    protected Board board;

    public Unit (char type, int x, int y, String name, int pool, int amount, int attack , int defense, Board board ) {
        super(type,x,y);
        this.name= name;
        healthPool=pool;
        healthAmount=amount;
        attackPoints=attack;
        defensePoints=defense;
        this.board = board;
    }

    public void setHealthPool(int pool){
        healthPool=pool;

    }
    public void setHealthAmount(int health){
        healthAmount=health;

    }
    public void setAttackPoints(int attack){
        attackPoints=attack;

    }
    public void setDefensePoints(int defense){
        defensePoints=defense;
    }

    public void moveUnitUp() {
        if (board.moveUnitUp(getXcoor(),getYcoor())) {
            super.setCoor(getXcoor() - 1, getYcoor());
        }
    }
    public void moveUnitDown() {
        if(board.moveUnitDown(getXcoor(),getYcoor())) {
            super.setCoor(getXcoor() + 1, getYcoor());
        }
    }
    public void moveUnitLeft() {
        if(board.moveUnitLeft(getXcoor(),getYcoor())) {
            super.setCoor(getXcoor(), getYcoor() - 1);
        }
    }
    public void moveUnitRight() {
        if(board.moveUnitRight(getXcoor(),getYcoor())) {
            super.setCoor(getXcoor(), getYcoor() + 1);
        }
    }

    public String getName(){
        return name;
    }

    public String toString() {
        return getTile()+"";
    }

}
