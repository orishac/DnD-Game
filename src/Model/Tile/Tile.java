package Model.Tile;

import Controller.BoardController;
import Model.Tile.Units.Unit;
import Model.Tile.Units.Visited;
import Model.Tile.Units.Visitor;

public abstract class Tile extends Range implements Visited, Visitor {
    private char tile;
    private Position position;

    public Tile (char type, int x, int y) {
        tile = type;
        position=new Position(x,y);
    }

    public int getXcoor() {
        return position.getxCord();
    }
    public int getYcoor() {
        return position.getyCord();
    }
    public char getTile() {
        return tile;
    }
    public void setCoor(int x, int y) {
        position.setxCord(x);
        position.setyCord(y);
    }

    public Position getPosition() {
        return new Position(getXcoor(),getYcoor());
    }

    public void setPosition(Position p) {
        position=p;
    }

    public String toString(){
        return tile+"";
    }


    public  void setTile(char c)
    {
        tile=c;
    }
}
