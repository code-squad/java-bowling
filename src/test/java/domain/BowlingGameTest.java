package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BowlingGameTest {
    BowlingGame bowlingGame = null;

    @Before
    public void setup() {
        String name = "HTW";
        bowlingGame = new BowlingGame(name);
    }

    @Test
    public void createPlayer() {
        assertTrue(BowlingGame.createPlayer("HTW") instanceof Player);
    }

    @Test
    public void createFrame() {
        assertEquals(10, bowlingGame.createFrame().size());
    }
}
