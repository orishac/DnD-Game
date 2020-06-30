package Controller;

import Model.Board.Board;
import Model.Tile.Empty;
import Model.Tile.Tile;
import Model.Tile.Units.Enemy.Boss;
import Model.Tile.Units.Enemy.Enemy;
import Model.Tile.Units.Enemy.Monster;
import Model.Tile.Units.Enemy.Trap;
import Model.Tile.Units.Player.*;
import Model.Tile.Wall;
import View.BoardView;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BoardController {

    private Board model;
    private BoardView view;
    private Player myPlayer;
    private List<Enemy> monsterList;
    private  List<List<String>> levels;
    private int currLevel=0;
    public boolean keepRunning=true;

    public BoardController (Board model, BoardView view, Player myPlayer, List monsterList) {
        this.model=model;
        this.view=view;
        this.myPlayer=myPlayer;
        this.monsterList = monsterList;
    }

    public BoardController (List<List<String>> levels) {
        this.levels=levels;
        loadLevel(0);
        currLevel++;
    }

    public void updateView() {
        view.PrintBoard(model.getBoard());
    }

    public void gameLoop() {
        if(!myPlayer.isAlive()) {
            view.printGameOver();
            keepRunning=false;
        }
        else if(monsterList.size()==0) {
            loadLevel(currLevel);
            currLevel++;
        }
        else
        {
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
    }
    public void moveMonsters() {
        for (Enemy e : monsterList) {
            e.onEnemyTurn();
        }
    }

    public void loadLevel(int index) {
        if(index<levels.size()) {
            List<String> level=levels.get(index);
            int x=level.size();
            int y=level.get(0).length();
            model = new Board(x, y);
            view = new BoardView();
            monsterList = new LinkedList<>();
            int i=0;
            int j;
            char current;
            for(String row : level) {
                for( j=0;j<row.length();j++) {
                    current=row.charAt(j);
                    if (current == '.') {
                        Tile empty = new Empty( i, j);
                        model.add(empty);
                    }
                    if (current == '#') {
                        Tile wall = new Wall( i, j);
                        model.add(wall);
                    }
                    if (current == 's') {
                        Monster monster = new Monster('s', i, j, "Lannister Solider", 80, 80 , 8 , 3, 3, 25, model, view);
                        model.add(monster);
                        monsterList.add(monster);
                    }
                    if (current == 'k') {
                        Monster monster = new Monster('k', i, j, "Lannister Knight", 200, 200 , 14 , 8, 4, 50, model, view);
                        model.add(monster);
                        monsterList.add(monster);
                    }
                    if (current == 'q') {
                        Monster monster = new Monster('q', i, j, "Queen’s Guard", 400, 400 , 20 , 15, 5, 100, model, view);
                        model.add(monster);
                        monsterList.add(monster);
                    }
                    if (current == 'z') {
                        Monster monster = new Monster('z', i, j, "Wright", 600, 600 , 30 , 15, 3, 100, model, view);
                        model.add(monster);
                        monsterList.add(monster);
                    }
                    if (current == 'b') {
                        Monster monster = new Monster('b', i, j, "Bear-Wright", 1000, 1000 , 75 , 30, 4, 250, model, view);
                        model.add(monster);
                        monsterList.add(monster);
                    }
                    if (current == 'g') {
                        Monster monster = new Monster('g', i, j, "Giant-Wright", 1500, 1500 , 100 , 40, 5, 500, model, view);
                        model.add(monster);
                        monsterList.add(monster);
                    }
                    if (current == 'w') {
                        Monster monster = new Monster('w', i, j, "White Walker", 2000, 2000 , 150 , 50, 6, 100, model, view);
                        model.add(monster);
                        monsterList.add(monster);
                    }
                    if (current == 'M') {
                        Monster monster = new Boss('M', i, j, "The Mountain", 1000, 1000 , 60 , 25, model, 6, 5, 500, view);
                        model.add(monster);
                        monsterList.add(monster);
                    }
                    if (current == 'C') {
                        Monster monster = new Boss('C', i, j, "Queen Cersei", 100, 100 , 10 , 10, model,1, 2 ,1000, view);
                        model.add(monster);
                        monsterList.add(monster);
                    }
                    if (current == 'K') {
                        Monster monster = new Boss('K', i, j, "Night’s King", 5000, 5000 , 300 , 150,  model, 8, 3, 5000, view);
                        model.add(monster);
                        monsterList.add(monster);
                    }
                    if (current == 'B') {
                        Enemy trap = new Trap('B', i, j, "Bonus Trap", 1, 1, 1, 1,  model , 1,
                                5,250, view);
                        model.add(trap);
                        monsterList.add(trap);
                    }
                    if (current == 'Q') {
                        Enemy trap = new Trap('Q', i, j, "Queen’s Trap", 250, 250, 50, 10,  model , 3,
                                7, 100, view);
                        model.add(trap);
                        monsterList.add(trap);
                    }
                    if (current == 'D') {
                        Enemy trap = new Trap('D', i, j, "Death Trap", 500, 500, 100, 20,  model , 1,
                                10, 250, view);
                        model.add(trap);
                        monsterList.add(trap);
                    }
                    if (current == '@') {
                        if(myPlayer==null) {
                            addPlayer(i,j);
                        }
                        else {
                            myPlayer.setCoor(i,j);
                        }
                    }
                }
                i++;
            }
        }
        else {
            view.printGameFinish();
            keepRunning=false;
        }
    }

    private void addPlayer(int x,int y) {
        Scanner scanner=new Scanner(System.in);
        view.showPlayers();
        int playerNumber=scanner.nextInt();
        List<Player> players=new LinkedList<>();
        players.add(new Warrior(x, y, "Jon Snow", 300, 300, 30, 4, 3, model, view));
        players.add(new Warrior(x, y, "The Hound", 400, 400, 20, 6, 5, model, view));
        players.add( new Mage(x, y, "Melisandre", 100, 100, 5, 1, 300, 15,
                30, 5, 6, model, view));
        players.add(new Mage(x, y, "Thoros of Myr", 250, 250, 25, 4, 150, 20,
                20, 3, 4, model, view));
        players.add(new Rogue(x, y, "Arya Stark", 150, 150, 40, 2, 20, model, view));
        players.add(new Rogue(x, y, "Bronn", 250, 250, 35, 3,50, model, view));
        players.add(new Hunter(x, y, "Ygritte", 220, 220, 30, 2,model, 6, view));
        myPlayer=players.get(playerNumber-1);
    }


}
