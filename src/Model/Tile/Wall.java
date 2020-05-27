package Model.Tile;

public class Wall extends Tile {


    public Wall(char type, int x, int y) {
        super('#', x, y);
    }

    public String toString(){
        return "#";
    }
}
