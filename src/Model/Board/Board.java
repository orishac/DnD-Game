package Model.Board;

import Model.Tile.Empty;
import Model.Tile.Position;
import Model.Tile.Tile;
import Model.Tile.Units.Enemy.Enemy;
import Model.Tile.Units.Enemy.Monster;
import Model.Tile.Units.Unit;
import Model.Tile.Wall;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board {

    private Tile[][] board;
    private List<Enemy> monsterList;//need to change monsterList to EnemyList.
    private Tile player;

    public Board(int x,int j) {
        board = new Tile[x][j];
        monsterList = new LinkedList<>();
    }

    public void add(Tile t) {
        int x = t.getXcoor();
        int y = t.getYcoor();
        board[x][y] = t;
    }

    public void setMonsterList(List<Enemy> monsterList) {
        this.monsterList = monsterList;
    }

    public int xlength() {
        return board.length;
    }

    public int ylength() {
        return board[0].length;
    }

    public Tile[][] getBoard() {
        return board;
    }

    public void setPlayer(Tile myPlayer){
        player=myPlayer;
    }


    public void addMonster(Monster t) {
        monsterList.add(t);
    }

    public List<Enemy> getMonstersInRange(int range) {
        Stream<Enemy> monsterStream=monsterList.stream().filter((monster)->range(player,monster)<range&monster.isAlive()&monster.isVisible());
        List<Enemy> monsterList=monsterStream.collect(Collectors.toList());
        return monsterList;
    }

    public List<Enemy> getLivingMosters(List<Enemy> monsterList) {
        Stream<Enemy> monsterStream=monsterList.stream().filter((monster)->monster.isAlive());
        List<Enemy> livingMonsterList=monsterStream.collect(Collectors.toList());
        return livingMonsterList;
    }

    public double range(Tile t1, Tile t2){
        return Math.sqrt((Math.pow((t1.getXcoor())-(t2.getXcoor()),2))+(Math.pow((t1.getYcoor())-(t2.getYcoor()),2)));
    }

    public void switchPlaces(Tile t1,Tile t2) {
        Position p1=t1.getPosition();
        Position p2=t2.getPosition();
        board[t1.getXcoor()][t1.getYcoor()]=t2;
        board[t2.getXcoor()][t2.getYcoor()]=t1;
        t1.setPosition(p2);
        t2.setPosition(p1);
    }

    public boolean canMoveUp(Tile t){
        return t.getXcoor()>0;
    }

    public boolean canMoveDown(Tile t) {
        return t.getXcoor()<board.length-1;
    }

    public boolean canMoveLeft(Tile t) { return t.getYcoor()>0; }

    public boolean canMoveRight(Tile t){ return  t.getYcoor()<board[0].length-1; }

    public Tile above(Tile t){
        if(canMoveUp(t)) {
            return board[t.getXcoor()-1][t.getYcoor()];
        }
        else {
            return new Wall(t.getXcoor()-1,t.getYcoor());
        }
    }

    public Tile below(Tile t){
        if(canMoveDown(t)) {
            return board[t.getXcoor()+1][t.getYcoor()];
        }
        else {
            return new Wall(t.getXcoor()+1,t.getYcoor());
        }
    }

    public Tile onLeft(Tile t) {
        if(canMoveLeft(t)) {
            return board[t.getXcoor()][t.getYcoor()-1];
        }
        else {
            return new Wall(t.getXcoor(),t.getYcoor()-1);
        }
    }

    public Tile onRight(Tile t) {
        if(canMoveRight(t)) {
            return board[t.getXcoor()][t.getYcoor()+1];
        }
        else {
            return new Wall(t.getXcoor(),t.getYcoor()+1);
        }
    }

    public Tile getPlayer() {
        return player;
    }

    public double rangeFromPlayer(Tile enemy) {
        return range(player,enemy);
    }

    public int getXDifferenceFromPlayer(Enemy e) {
        return e.getXcoor()-player.getXcoor();
    }

    public int getYDifferenceFromPlayer(Enemy e) {
        return e.getYcoor()-player.getYcoor();
    }

    public Enemy getClosestEnemy(List<Enemy> monsterList) {
        double minRange=-1;
        Enemy closestMonster=null;
        for(Enemy e:monsterList)
        {
            if(minRange==-1) {
                minRange=range(e,player);
                closestMonster=e;
            }
            else if(range(e,player)<minRange)
            {
                minRange=range(e,player);
                closestMonster=e;
            }
        }
        return closestMonster;
    }

    public void removeEnemy(Enemy enemy) {
        monsterList.remove(enemy);
    }

    public void removePlayer() {
        player=null;
    }


    public void removeUnit(Unit unit, int x, int y) {
        monsterList.remove(unit);
        board[x][y] = new Empty(x,y);
    }
}

