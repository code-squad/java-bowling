package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstThrowTest {
    private FirstThrow firstThrow;

    @Before
    public void setUp() throws Exception {
        firstThrow = new FirstThrow();
    }

    @Test
    public void updateScore() {
        assertEquals(9, firstThrow.updateScore(9));
    }

    @Test
    public void countPinsStanding() {
        firstThrow.updateScore(7);
        assertEquals(3, firstThrow.countPinsStanding());
    }

    @Test
    public void toStringTest_Strike() {
        firstThrow.updateScore(10);
        assertEquals("X", firstThrow.toString());
    }

    @Test
    public void toStringTest_Number() {
        firstThrow.updateScore(9);
        assertEquals("9", firstThrow.toString());
    }
}