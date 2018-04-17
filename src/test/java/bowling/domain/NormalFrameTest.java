package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NormalFrameTest {
    private NormalFrame frame;

    @Before
    public void setUp() throws Exception {
        frame = new NormalFrame(1);
    }

    @Test
    public void firstIsPlayed_False() {
        assertFalse(frame.firstIsPlayed());
    }

    @Test
    public void firstIsPlayed_True() {
        frame.updateBowls(5);
        assertTrue(frame.firstIsPlayed());
    }

    @Test
    public void secondIsPlayed_False() {
        frame.updateBowls(5);
        assertFalse(frame.secondIsPlayed());
    }

    @Test
    public void secondIsPlayed_True() {
        frame.updateBowls(5);
        frame.updateBowls(5);
        assertTrue(frame.secondIsPlayed());
    }
}