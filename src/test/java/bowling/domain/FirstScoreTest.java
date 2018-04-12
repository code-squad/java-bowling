package bowling.domain;

import bowling.domain.score.FirstScore;
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
    public void toStringTest_Not_Played_Yet() {
        assertEquals(" ", firstScore.toString(false));
    }

    @Test
    public void toStringTest_Strike() {
        firstScore.updateScore(10);
        assertEquals("X", firstScore.toString(true));
    }

    @Test
    public void toStringTest_Number() {
        firstScore.updateScore(9);
        assertEquals("9", firstScore.toString(false));
    }

    @Test
    public void toStringTest_Zero() {
        firstScore.updateScore(0);
        assertEquals("-", firstScore.toString(false));
    }
}