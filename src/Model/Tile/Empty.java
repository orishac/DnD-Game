package Model.Tile;

import Model.Tile.Units.Visitor;

public class Empty extends Tile {

    public Empty(char type, int x, int y) {
        super('.', x, y);
    }

    public String toString(){
        return ".";
    }

    @Override
    public void acceptInteraction(Visitor visitor) {
        visitor.interact(this);
    }
}
