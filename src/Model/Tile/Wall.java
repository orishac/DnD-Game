package Model.Tile;

import Model.Tile.Units.Visitor;

public class Wall extends Tile {


    public Wall(char type, int x, int y) {
        super('#', x, y);
    }

    public String toString(){
        return "#";
    }

    @Override
    public void acceptInteraction(Visitor visitor) {
        visitor.interact(this);
    }
}
