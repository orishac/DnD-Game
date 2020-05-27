package View;

import Model.Tile.Tile;

public class BoardView {

    private TileView[][] boardview;

    public void PrintBoard(Tile[][] board) {
        for(int i = 0; i<board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
    }
}
