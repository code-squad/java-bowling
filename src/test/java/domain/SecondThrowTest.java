package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SecondThrowTest {
    private SecondThrow secondThrow;

    @Before
    public void setUp() throws Exception {
        secondThrow = new SecondThrow();
    }

    @Test
    public void updateScore() {
        int pinsKnocked = secondThrow.updateScore(4, 2);
        assertEquals(2, pinsKnocked);
    }

    @Test
    public void toStringTest_Spare() {
        secondThrow.updateScore(2, 2);
        assertEquals("|/", secondThrow.toString());
    }

    @Test
    public void toStringTest_Not_Played_Yet() {
        assertEquals("  ", secondThrow.toString());
    }

    @Test
    public void toStringTest_Zero() {
        secondThrow.updateScore(2, 0);
        assertEquals("|-", secondThrow.toString());
    }

    @Test
    public void toStringTest_Number() {
        secondThrow.updateScore(2, 1);
        assertEquals("|1", secondThrow.toString());
    }
}