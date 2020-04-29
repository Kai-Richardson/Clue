package edu.up.cs301;

import org.junit.Test;

import edu.up.cs301.game.GameFramework.Clue.Card;
import edu.up.cs301.game.GameFramework.Clue.ClueGameState;
import edu.up.cs301.game.GameFramework.Game;
import edu.up.cs301.game.GameFramework.infoMessage.GameState;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void TestGetMovesLeft() {
        String[] str = new String[3];
        ClueGameState state = new ClueGameState(3, str, 0);
        int left = state.getMovesLeft();
        assertEquals(0, left);
    }
    @Test
    public void TestDM(){
        String[] str = new String[3];
        ClueGameState state = new ClueGameState(3, str, 0);
        int left = state.getMovesLeft();
        state.decreaseMoves();
        int current = state.getMovesLeft();
        assertNotEquals(left, current);
    }
    @Test
    public void TestWT(){
        String[] str = new String[3];
        ClueGameState state = new ClueGameState(3, str, 0);
        int turn = state.getWhoseTurn();
        assertEquals(0, turn);
    }
    @Test
    public void TestSP(){
        String[] str = new String[3];
        ClueGameState state = new ClueGameState(3, str, 0);
        state.setSugPerson("bob");
        String person = state.getSugPerson();
        assertNotEquals(null, person);
    }
    @Test
    public void TestSSW(){
        String[] str = new String[3];
        ClueGameState state = new ClueGameState(3, str, 0);
        state.setSugWeapon("bob");
        String gog = state.getSugWeapon();
        assertEquals(gog, "bob");
    }
    @Test
    public void TestSSR(){
        String[] str = new String[3];
        ClueGameState state = new ClueGameState(3, str, 0);
        state.setSugRoom("bob");
        String gog = state.getSugRoom();
        assertEquals(gog, "bob");
    }
}