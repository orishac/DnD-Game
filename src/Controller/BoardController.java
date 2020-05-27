package Controller;

import Model.Board.Board;
import Model.Tile.Tile;
import Model.Tile.Units.Player.Player;
import Model.Tile.Units.Unit;
import View.BoardView;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BoardController {

    private Board model;
    private BoardView view;
    private Player myPlayer;
    private List<Unit> monsterList;

    public BoardController (Board model, BoardView view, Player myPlayer, List monsterList) {
        this.model=model;
        this.view=view;
        this.myPlayer=myPlayer;
        this.monsterList = monsterList;
    }

    public void updateView() {
        view.PrintBoard(model.getBoard());
    }

    public void gameLoop() {
        Scanner myScanner = new Scanner(System.in);
        char chosen = myScanner.next().charAt(0);
        if (chosen == 'w') {
            myPlayer.moveUnitUp();
            moveMonsters();
        }
        if (chosen == 's') {
            myPlayer.moveUnitDown();
            moveMonsters();
        }
        if (chosen == 'a') {
            myPlayer.moveUnitLeft();
            moveMonsters();
        }
        if (chosen == 'd') {
            myPlayer.moveUnitRight();
            moveMonsters();
        }
        view.PrintBoard(model.getBoard());
    }
    public void moveMonsters() {
        for (Unit m : monsterList) {
            int rnd = (int) (Math.random() * 4);
            if (rnd == 0)
                m.moveUnitUp();
            if (rnd == 1)
                m.moveUnitDown();
            if (rnd == 2)
                m.moveUnitLeft();
            if (rnd == 3)
                m.moveUnitRight();
        }
    }

}
