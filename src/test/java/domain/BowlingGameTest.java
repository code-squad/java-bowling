package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    List<String> names;
    BowlingGame bowlingGame;

    @Before
    public void setUp() {
        names = Arrays.asList("htw");
    }

    @Test
    public void generateGame() {
        bowlingGame = new BowlingGame(names);
    }

    @Test
    public void createPlayer() {
        bowlingGame = new BowlingGame(names);
        List<Player> players = bowlingGame.createPlayer(names);
        assertEquals(1, players.size());
    }

    @Test
    public void createFirstFrame() {
        bowlingGame.createFirstFrame(1);
    }
}
