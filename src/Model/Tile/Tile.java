package Model.Tile;

import Controller.BoardController;

public abstract class Tile {
    private char tile;
    private int xCoor;
    private int yCoor;

    public Tile (char type, int x, int y) {
        tile = type;
        xCoor = x;
        yCoor= y;
    }

    public int getXcoor() {
        return xCoor;
    }
    public int getYcoor() {
        return yCoor;
    }
    public char getTile() {
        return tile;
    }
    public void setCoor(int x, int y) {
        xCoor=x;
        yCoor=y;
    }
}
