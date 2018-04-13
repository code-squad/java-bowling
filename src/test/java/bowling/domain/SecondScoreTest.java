package bowling.domain;

import bowling.domain.score.FirstScore;
import bowling.domain.score.SecondScore;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SecondScoreTest {
    private SecondScore secondScore;
    private FirstScore firstScore;

    @Before
    public void setUp() throws Exception {
        secondScore = new SecondScore();
        firstScore = new FirstScore();
    }

    @Test
    public void updateScore() {
        assertEquals(2, secondScore.updateScore(2));
    }

    @Test
    public void toStringTest_Not_Played_Yet() {
        assertEquals("  ", secondScore.toString(firstScore));
    }

    @Test
    public void toStringTest_Spare() {
        firstScore.updateScore(8);
        secondScore.updateScore(2);
        assertEquals("|/", secondScore.toString(firstScore));
    }

    @Test
    public void toStringTest_Number() {
        firstScore.updateScore(8);
        secondScore.updateScore(1);
        assertEquals("|1", secondScore.toString(firstScore));
    }

    @Test
    public void toStringTest_Zero() {
        firstScore.updateScore(8);
        secondScore.updateScore(0);
        assertEquals("|-", secondScore.toString(firstScore));
    }
}