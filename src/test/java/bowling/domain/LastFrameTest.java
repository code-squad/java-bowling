package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LastFrameTest extends FrameTest {
    @Before
    public void setUp() {
        super.frame = new LastFrame();
    }

    @Test(expected = IllegalArgumentException.class)
    public void setTryOverflow() {
        setTry(10);
        setTry(5);
        setTry(6);
    }

    @Test
    public void notYetWithSpare() {
        testTry(3);
        assertTrue(frame.notYet());

        testTry(7);
        assertTrue(frame.notYet());

        testTry(10);
        assertFalse(frame.notYet());
    }

    private void testTry(int downCount) {
        frame.setTry(new Try(downCount));
    }

    @Test
    public void notYetWithStrike() {
        testTry(10);
        assertTrue(frame.notYet());

        testTry(10);
        assertTrue(frame.notYet());

        testTry(10);
        assertFalse(frame.notYet());
    }

    @Test
    public void notYetWithMiss() {
        testTry(2);
        assertTrue(frame.notYet());

        testTry(1);
        assertFalse(frame.notYet());
    }

    @Test
    public void notYetWithGutter() {
        testTry(0);
        assertTrue(frame.notYet());

        testTry(0);
        assertFalse(frame.notYet());
    }

    @Test(expected = IllegalStateException.class)
    public void setTryAtStrike() {
        setTry(10);
        setTry(5);
        setTry(4);
        setTry(1);
    }

    @Test(expected = IllegalStateException.class)
    public void setTryAtSpare() {
        setTry(4);
        setTry(6);
        setTry(1);
        setTry(2);
    }

    @Test(expected = IllegalStateException.class)
    public void setTryAtNormal() {
        setTry(4);
        setTry(5);
        setTry(1);
    }

    @Test(expected = IllegalStateException.class)
    public void setTryAtGutter() {
        setTry(0);
        setTry(5);
        setTry(1);
    }

    @Test
    public void tripleStrike() {
        testTry(10);
        testTry(10);
        testTry(10);
        assertEquals("X|X|X", frame.showMessage());
    }

    @Test
    public void doubleStrike() {
        testTry(10);
        testTry(10);
        assertEquals("X|X ", frame.showMessage());
    }

    @Test
    public void doubleStrikeAnd() {
        testTry(10);
        testTry(10);
        testTry(4);
        assertEquals("X|X|4", frame.showMessage());
    }

    @Test
    public void spare() {
        testTry(4);
        testTry(6);
        assertEquals(" 4|/ ", frame.showMessage());
    }

}