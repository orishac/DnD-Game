package View;

import Model.Tile.Tile;
import Model.Tile.Units.Player.Player;
import Model.Tile.Units.Unit;

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

    public void PrintCombatView(Unit attacker, Unit defender, int attackRoll, int defenseRoll, int damage) {
        System.out.print(attacker.getName()+" engaged in combat with "+defender.getName()+"\n");
        System.out.print(attacker.getName()+" rolled "+attackRoll+" attack points.\n");
        System.out.print(defender.getName()+" rolled "+defenseRoll+" defense points.\n");
        System.out.print(attacker.getName()+" dealt "+damage+" damage to "+defender.getName()+".\n");
    }

}
