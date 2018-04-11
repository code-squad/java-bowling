package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SecondScoreTest {
    private SecondScore secondScore;

    @Before
    public void setUp() throws Exception {
        secondScore = new SecondScore();
    }

    @Test
    public void updateScore() {
        assertEquals(2, secondScore.updateScore(2));
    }

    @Test
    public void toStringTest_Not_Played_Yet() {
        assertEquals("  ", secondScore.toString(false));
    }

    @Test
    public void toStringTest_Spare() {
        secondScore.updateScore(2);
        assertEquals("|/", secondScore.toString(true));
    }

    @Test
    public void toStringTest_Number() {
        secondScore.updateScore(1);
        assertEquals("|1", secondScore.toString(false));
    }

    @Test
    public void toStringTest_Zero() {
        secondScore.updateScore(0);
        assertEquals("|-", secondScore.toString(false));
    }
}