import Model.Tile.Empty;
import Model.Tile.Tile;
import Model.Tile.Units.Enemy.Enemy;
import Model.Tile.Units.Enemy.Monster;
import View.BoardView;
import org.junit.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Model.Tile.Units.Player.Warrior;
import Model.Board.Board;

public class ProjectTest {
    private Board board;
    private Warrior warrior;
    private Enemy enemy;

    @Before
    public void initTest() {
        board = new Board(2,2);
        BoardView view = new BoardView();
        warrior = new Warrior(0,0, "John Snow", 100, 100, 50, 50, 3, board, view);
        enemy = new Monster('s',0,1,"Soldier", 100,100,10, 10,
                3, 25,board, view);
        Empty empty1 = new Empty(1,0);
        Empty empty2 = new Empty(1,1);
        board.add(warrior);
        board.add(enemy);
        board.add(empty1);
        board.add(empty2);
    }

    @Test
    public void testRange() {
        Assert.assertEquals("The range between Tile <0,0> and <1,0> should be", board.range((board.getTile(0,0)),
                board.getTile(1,0)), 1, 0.0000001);
    }

    @Test
    public void testSwitchPlaces() {
        board.switchPlaces(board.getTile(0,0), board.getTile(1,1));
        Assert.assertEquals(board.getTile(1,1), warrior);
    }

    @Test
    public void canMoveDown() {
        Assert.assertTrue(board.canMoveDown(warrior));
    }

    @Test
    public void cannotMoveUp() {
        Assert.assertFalse(board.canMoveUp(warrior));
    }

    @Test
    public void enemyOnRight() {
        Assert.assertEquals(board.onRight(warrior), enemy);
    }


}
