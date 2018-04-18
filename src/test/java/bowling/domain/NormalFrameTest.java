package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NormalFrameTest {
    private NormalFrame frame;

    @Before
    public void setUp() throws Exception {
        frame = new NormalFrame();
    }

    @Test
    public void bowl() {
        assertEquals(new Integer(8), frame.bowl(8));
    }

    @Test
    public void firstIsPlayed_True() {
        frame.bowl(8);
        assertTrue(frame.firstIsPlayed());
    }

    @Test
    public void firstIsPlayed_False() {
        assertFalse(frame.firstIsPlayed());
    }

    @Test
    public void secondIsPlayed_True() {
        frame.bowl(8);
        frame.bowl(2);
        assertTrue(frame.secondIsPlayed());
    }

    @Test
    public void secondIsPlayed_False() {
        frame.bowl(8);
        assertFalse(frame.secondIsPlayed());
    }

    @Test
    public void firstIsStrike_True() {
        frame.bowl(10);
        assertTrue(frame.firstIsStrike());
    }

    @Test
    public void firstIsStrike_False() {
        frame.bowl(9);
        assertFalse(frame.firstIsStrike());
    }

    @Test
    public void secondIsSpare_True() {
        frame.bowl(8);
        frame.bowl(2);
        assertTrue(frame.secondIsSpare());
    }

    @Test
    public void secondIsSpare_False() {
        frame.bowl(8);
        frame.bowl(1);
        assertFalse(frame.secondIsSpare());
    }

    @Test
    public void toStringTest() {
    }
}