package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SecondScoreTest {
    private FirstScore firstScore;
    private SecondScore secondScore;

    @Before
    public void setUp() throws Exception {
        firstScore = new FirstScore();
        secondScore = new SecondScore();
    }

    @Test
    public void updateScore() {
        int pinsKnocked = secondScore.updateScore(2);
        assertEquals(2, pinsKnocked);
    }

    @Test
    public void toStringTest_Spare() {
        firstScore.updateScore(8);
        secondScore.updatePinsStanding(firstScore);
        secondScore.updateScore(2);
        assertEquals("|/", secondScore.toString());
    }

    @Test
    public void toStringTest_Not_Played_Yet() {
        assertEquals("  ", secondScore.toString());
    }

    @Test
    public void toStringTest_Zero() {
        secondScore.updateScore(0);
        assertEquals("|-", secondScore.toString());
    }

    @Test
    public void toStringTest_Number() {
        secondScore.updateScore(1);
        assertEquals("|1", secondScore.toString());
    }
}