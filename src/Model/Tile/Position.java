package Model.Tile;

public class Position {
    private int xCord;
    private int yCord;

    public Position(int xCord,int yCord) {
        this.xCord=xCord;
        this.yCord=yCord;
    }

    public void setxCord(int xCord) {
        this.xCord = xCord;
    }

    public void setyCord(int yCord) {
        this.yCord = yCord;
    }

    public int getxCord() {
        return xCord;
    }

    public int getyCord() {
        return yCord;
    }
}
