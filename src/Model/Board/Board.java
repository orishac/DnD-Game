package Model.Board;

import Model.Tile.Tile;
import Model.Tile.Units.Enemy.Enemy;
import Model.Tile.Units.Enemy.Monster;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board {

    private Tile[][] board;
    private List<Monster> monsterList;
    private Tile player;

    public Board(int x,int j) {
        board = new Tile[x][j];
        monsterList = new LinkedList<Monster>();
    }

    public void add(Tile t) {
        int x = t.getXcoor();
        int y = t.getYcoor();
        board[x][y] = t;
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

    public boolean moveUnitUp(int x, int y) {
        boolean moved = false;
        Tile toSave = board[x-1][y];
        if (toSave.toString()==".") {
            board[x-1][y] = board[x][y];
            board[x][y] = toSave;
            moved = true;
        }
        return moved;
    }
    public boolean moveUnitDown(int x, int y) {
        boolean moved = false;
        Tile toSave = board[x+1][y];
        if (toSave.toString()==".") {
            board[x+1][y] = board[x][y];
            board[x][y] = toSave;
            moved = true;
        }
        return moved;
    }
    public boolean moveUnitLeft(int x, int y) {
        boolean moved = false;
        Tile toSave = board[x][y-1];
        if (toSave.toString()==".") {
            board[x][y-1] = board[x][y];
            board[x][y] = toSave;
            moved = true;
        }
        return moved;
    }
    public boolean moveUnitRight(int x, int y) {
        boolean moved = false;
        Tile toSave = board[x][y+1];
        if (toSave.toString()==".") {
            board[x][y+1] = board[x][y];
            board[x][y] = toSave;
            moved = true;
        }
        return moved;
    }
    public void addMonster(Monster t) {
        monsterList.add(t);
    }

    public List<Monster> getMonstersInRange(int range) {
        Stream<Monster> monsterStream=monsterList.stream().filter((monster)->range(player,monster)<range&monster.isAlive());
        List<Monster> monsterList=monsterStream.collect(Collectors.toList());
        return monsterList;
    }

    public List<Monster> getLivingMosters(List<Monster> monsterList) {
        Stream<Monster> monsterStream=monsterList.stream().filter((monster)->monster.isAlive());
        List<Monster> livingMonsterList=monsterStream.collect(Collectors.toList());
        return livingMonsterList;
    }

    public double range(Tile t1, Tile t2){
        return Math.sqrt(Math.pow(t1.getXcoor()-t2.getXcoor(),2)+Math.pow(t1.getYcoor()-t2.getYcoor(),2));
    }

}

