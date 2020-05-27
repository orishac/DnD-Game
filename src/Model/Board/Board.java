package Model.Board;

import Model.Tile.Tile;
import Model.Tile.Units.Enemy.Enemy;
import Model.Tile.Units.Enemy.Monster;

import java.util.LinkedList;
import java.util.List;

public class Board {

    private Tile[][] board;
    private List<Tile> monsterList;
    private Tile player;

    public Board(int x,int j) {
        board = new Tile[x][j];
        monsterList = new LinkedList<Tile>();
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
    public void addMonster(Tile t) {
        monsterList.add(t);
    }


}

