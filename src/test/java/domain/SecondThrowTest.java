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
    public void toStringTest() {
        secondThrow.updateScore(2, 2);
        assertEquals("/", secondThrow.toString());
    }
}