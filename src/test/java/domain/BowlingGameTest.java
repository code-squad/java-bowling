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
        createPlayer();
        bowlingGame.bowl(InputView.getThrowing(scanner, 1));
    }

    @Test
    public void isEndFrame() {
        createPlayer();
        bowlingGame.bowl(10);
        assertTrue(bowlingGame.isEndFrame());
    }
}
