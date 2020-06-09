package Model.Tile;

public abstract class Range {
    public int getRange(Tile a, Tile b) {
        return (int) Math.sqrt((Math.pow(a.getYcoor()-b.getYcoor(), 2))+(Math.pow(a.getXcoor()-b.getXcoor(),2)));
    }


}
