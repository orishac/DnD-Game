import Model.Board.Board;
import Controller.BoardController;
import Model.Tile.Empty;
import Model.Tile.Wall;
import Model.Tile.Tile;
import Model.Tile.Units.Enemy.Monster;
import Model.Tile.Units.Enemy.Trap;
import Model.Tile.Units.Player.Mage;
import Model.Tile.Units.Player.Player;
import Model.Tile.Units.Player.Rogue;
import Model.Tile.Units.Player.Warrior;
import View.BoardView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Gameplay {
    public static void main(String[] args) {
        try {
            Player myPlayer = null;
            Scanner scanner = new Scanner(new File("/Users/orish/OneDrive/Desktop/Levels/level1.txt"));
            Scanner scanner2 = new Scanner(new File("/Users/orish/OneDrive/Desktop/Levels/level1.txt"));
            int x = 0;
            int y = 0;
            while (scanner2.hasNextLine()) {
                y = 0;
                String line = scanner2.nextLine();
                for (int j = 0; j < line.length(); j++) {
                    y = y + 1;
                }
                x = x + 1;
            }
            System.out.println("Select player:\n" +
                    "1. Jon Snow             Health: 300/300         Attack: 30              Defense: 4              Level: 1                Experience: 0/50                Cooldown: 0/3 \n" +
                    "2. The Hound            Health: 400/400         Attack: 20              Defense: 6              Level: 1                Experience: 0/50                Cooldown: 0/5 \n" +
                    "3. Melisandre           Health: 100/100         Attack: 5               Defense: 1              Level: 1                Experience: 0/50                Mana: 75/300            Spell Power: 15 \n" +
                    "4. Thoros of Myr        Health: 250/250         Attack: 25              Defense: 4              Level: 1                Experience: 0/50                Mana: 37/150            Spell Power: 20 \n" +
                    "5. Arya Stark           Health: 150/150         Attack: 40              Defense: 2              Level: 1                Experience: 0/50                Energy: 100/100 \n" +
                    "6. Bronn                Health: 250/250         Attack: 35              Defense: 3              Level: 1                Experience: 0/50                Energy: 100/100 \n" +
                    "7. Ygritte              Health: 220/220         Attack: 30              Defense: 2              Level: 1                Experience: 0/50                Arrows: 10              Range: 6 \n");
            Scanner myScanner = new Scanner(System.in);
            int chosen = myScanner.nextInt();
            char current;
            int i = 0;
            Board model = new Board(x, y);
            List<Tile> monsterlist = new LinkedList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (int j = 0; j < model.ylength(); j++) {
                    current = line.charAt(j);
                    if (current == '.') {
                        Tile empty = new Empty( i, j);
                        model.add(empty);
                    }
                    if (current == '#') {
                        Tile wall = new Wall( i, j);
                        model.add(wall);
                    }
                    if (current == 's') {
                        Tile monster = new Monster('s', i, j, "Lannister Solider", 80, 80 , 8 , 3, 3, model);
                        model.add(monster);
                        monsterlist.add(monster);
                    }
                    if (current == 'k') {
                        Tile monster = new Monster('k', i, j, "Lannister Knight", 200, 200 , 14 , 8, 4, model);
                        model.add(monster);
                        monsterlist.add(monster);
                    }
                    if (current == 'q') {
                        Tile monster = new Monster('q', i, j, "Queen’s Guard", 400, 400 , 20 , 15, 5, model);
                        model.add(monster);
                        monsterlist.add(monster);
                    }
                    if (current == 'z') {
                        Tile monster = new Monster('z', i, j, "Wright", 600, 600 , 30 , 15, 3, model);
                        model.add(monster);
                        monsterlist.add(monster);
                    }
                    if (current == 'b') {
                        Tile monster = new Monster('b', i, j, "Bear-Wright", 1000, 1000 , 75 , 30, 4, model);
                        model.add(monster);
                        monsterlist.add(monster);
                    }
                    if (current == 'g') {
                        Tile monster = new Monster('g', i, j, "Giant-Wright", 1500, 1500 , 100 , 40, 5, model);
                        model.add(monster);
                        monsterlist.add(monster);
                    }
                    if (current == 'w') {
                        Tile monster = new Monster('w', i, j, "White Walker", 2000, 2000 , 150 , 50, 6, model);
                        model.add(monster);
                        monsterlist.add(monster);
                    }
                    if (current == 'M') {
                        Tile monster = new Monster('M', i, j, "The Mountain", 1000, 1000 , 60 , 25, 6, model);
                        model.add(monster);
                        monsterlist.add(monster);
                    }
                    if (current == 'C') {
                        Tile monster = new Monster('C', i, j, "Queen Cersei", 100, 100 , 10 , 10, 1, model);
                        model.add(monster);
                        monsterlist.add(monster);
                    }
                    if (current == 'K') {
                        Tile monster = new Monster('K', i, j, "Night’s King", 5000, 5000 , 300 , 150, 8, model);
                        model.add(monster);
                        monsterlist.add(monster);
                    }
                    if (current == 'B') {
                        Tile trap = new Trap('B', i, j, "Bonus Trap", 1, 1, 1, 1,  model , 1,
                        5);
                        model.add(trap);
                    }
                    if (current == 'Q') {
                        Tile trap = new Trap('Q', i, j, "Queen’s Trap", 250, 250, 50, 10,  model , 3,
                                7);
                        model.add(trap);
                    }
                    if (current == 'D') {
                        Tile trap = new Trap('D', i, j, "Death Trap", 500, 500, 100, 20,  model , 1,
                                10);
                        model.add(trap);
                    }
                    if (current == '@') {
                        x = i;
                        y = j;
                        if (chosen == 1) {
                            myPlayer = new Warrior(x, y, "Jon Snow", 300, 300, 30, 4, 3, model);
                            System.out.print("You have selected:\n" +
                                    "Jon Snow \n");
                            model.add(myPlayer);
                        }
                        if (chosen == 2) {
                            myPlayer = new Warrior(x, y, "The Hound", 400, 400, 20, 6, 5, model);
                            System.out.print("You have selected:\n" +
                                    "The Hound \n");
                            model.add(myPlayer);
                        }
                        if (chosen == 3) {
                            myPlayer = new Mage(x, y, "Melisandre", 100, 100, 5, 1, model);
                            System.out.print("You have selected:\n" +
                                    "Melisandre \n");
                            model.add(myPlayer);
                        }
                        if (chosen == 4) {
                            myPlayer = new Mage(x, y, "Thoros of Myr", 250, 250, 25, 4, model);
                            System.out.print("You have selected:\n" +
                                    "Thoros of Myr \n");
                            model.add(myPlayer);
                        }
                        if (chosen == 5) {
                            myPlayer = new Rogue(x, y, "Arya Stark", 150, 150, 40, 2, 20, model);
                            System.out.print("You have selected:\n" +
                                    "Arya Stark \n");
                            model.add(myPlayer);
                        }
                        if (chosen == 6) {
                            myPlayer = new Rogue(x, y, "Bronn", 250, 250, 35, 3,50, model);
                            System.out.print("You have selected:\n" +
                                    "Bronn \n");
                            model.add(myPlayer);
                        }
                    }
                }
                i = i + 1;
            }
            BoardView view = new BoardView();
            BoardController controller = new BoardController(model, view, myPlayer, monsterlist);
            controller.updateView();
            boolean keepRunning = false;
            while (keepRunning==false) {
                controller.gameLoop();
            }
        }
         catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


