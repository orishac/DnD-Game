package Model.Tile;

import Controller.BoardController;
import Model.Tile.Units.Unit;
import Model.Tile.Units.Visited;
import Model.Tile.Units.Visitor;

public abstract class Tile implements Visited {
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
        return new Position(getXcoor(),getXcoor());
    }

    public void setPosition(Position p) {
        position=p;
    }

    public abstract void acceptInteraction(Visitor visitor);

}
