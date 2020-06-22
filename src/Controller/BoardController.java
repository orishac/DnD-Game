package Controller;

import Model.Board.Board;
import Model.Tile.Tile;
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
    private List<Monster> monsterList;

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
        moveMonsters();
        myPlayer.printStatus();
        view.PrintBoard(model.getBoard());

    }
    public void moveMonsters() {
        for (Monster m : monsterList) {
            if (model.rangeFromPlayer(m) < m.getVisionRange()) {
                int dx = m.getXcoor() - myPlayer.getXcoor();
                int dy = m.getYcoor() - myPlayer.getYcoor();
                if (Math.abs(dy) > Math.abs(dx)) {
                    if (dy > 0) {
                        m.moveLeft();
                    } else {
                        m.moveRight();
                    }
                } else {
                    if (dx > 0) {
                        m.moveUp();
                    } else {
                        m.moveDown();
                    }
                }
            } else {
                int rnd = (int) (Math.random() * 4);
                if (rnd == 0)
                    m.moveUp();
                if (rnd == 1)
                    m.moveDown();
                if (rnd == 2)
                    m.moveLeft();
                if (rnd == 3)
                    m.moveRight();
            }
        }
    }

}
