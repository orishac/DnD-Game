package Controller;

import Model.Board.Board;
import Model.Tile.Tile;
import Model.Tile.Units.Enemy.Enemy;
import Model.Tile.Units.Enemy.Monster;
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
    private List<Enemy> monsterList;

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
            myPlayer.moveUp();
        }
        if (chosen == 's') {
            myPlayer.moveDown();
        }
        if (chosen == 'a') {
            myPlayer.moveLeft();
        }
        if (chosen == 'd') {
            myPlayer.moveRight();
        }
        if (chosen == 'e') {
            myPlayer.castSpecialAbility();
        }
        moveMonsters();
        myPlayer.printStatus();
        view.PrintBoard(model.getBoard());

    }
    public void moveMonsters() {
        for (Enemy e : monsterList) {
            e.onEnemyTurn();
        }
    }


}
