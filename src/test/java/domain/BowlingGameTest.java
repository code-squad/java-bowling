package domain;

import org.junit.Before;
import org.junit.Test;
import view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BowlingGameTest {
    List<String> names;
    BowlingGame bowlingGame;

    @Before
    public void setUp() {
        names = Arrays.asList("htw");
        bowlingGame = new BowlingGame();
    }

    @Test
    public void generateGame() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void createPlayer() {
        List<Player> players = bowlingGame.createPlayer(names);
        assertEquals(1, players.size());
    }

    @Test
    public void bowl() {
        Scanner scanner = new Scanner("10");
        List<Player> players = bowlingGame.createPlayer(Arrays.asList("htw", "pjs"));
        bowlingGame.bowl(players.get(0), InputView.getThrowing(scanner, players.get(0).getName()));
    }

    @Test
    public void isEndFrame() {
//        Scanner scanner = new Scanner("10");
//        List<Player> players = bowlingGame.createPlayer(Arrays.asList("htw", "pjs"));
//        assertTrue(bowlingGame.isEndFrame(players.get));
    }
}
