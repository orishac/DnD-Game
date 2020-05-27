package Model.Tile;

public class Empty extends Tile {

    public Empty(char type, int x, int y) {
        super('.', x, y);
    }

    public String toString(){
        return ".";
    }

}
