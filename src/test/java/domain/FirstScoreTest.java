package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstScoreTest {
    private FirstScore firstScore;

    @Before
    public void setUp() throws Exception {
        firstScore = new FirstScore();
    }

    @Test
    public void updateScore() {
        assertEquals(9, firstScore.updateScore(9));
    }

    @Test
    public void countPinsStanding() {
        firstScore.updateScore(7);
        assertEquals(3, firstScore.countPinsStanding());
    }

    @Test
    public void toStringTest_Strike() {
        firstScore.updateScore(10);
        assertEquals("X", firstScore.toString());
    }

    @Test
    public void toStringTest_Number() {
        firstScore.updateScore(9);
        assertEquals("9", firstScore.toString());
    }
}