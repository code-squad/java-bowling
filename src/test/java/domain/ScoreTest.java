package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreTest {
    Score score;

    @Before
    public void setUp() throws Exception {
        score = new Score();
    }

    @Test
    public void isStrike_True() {
        score.update(10);
        assertTrue(score.isStrike());
    }

    @Test
    public void isStrike_False() {
        score.update(9);
        assertFalse(score.isStrike());
    }

    @Test
    public void isSpare_True() {
        score.update(8);
        score.update(2);
        assertTrue(score.isSpare());
    }

    @Test
    public void isSpare_False() {
        score.update(8);
        score.update(1);
        assertFalse(score.isSpare());
    }

    @Test
    public void toStringTest_No_Score_Yet() {
        assertEquals("   ", score.toString());
    }

    @Test
    public void toStringTest_Strike() {
        score.update(10);
        assertEquals("X  ", score.toString());
    }

    @Test
    public void toStringTest_Spare() {
        score.update(8);
        score.update(2);
        assertEquals("8|/", score.toString());
    }

    @Test
    public void toStringTest_One_Number() {
        score.update(6);
        assertEquals("6", score.toString());
    }

    @Test
    public void toStringTest_Two_Numbers() {
        score.update(6);
        score.update(3);
        assertEquals("6|3", score.toString());
    }
}