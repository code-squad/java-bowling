package bowling.domain.frame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NormalFrameTest {
    private Frame frame;

    @Before
    public void setUp() throws Exception {
        frame = new NormalFrame(1);
    }

    @Test
    public void isComplete_False_Not_Played() {
        assertFalse(frame.isNewFrame());
    }

    @Test
    public void isComplete_False_Played_And_Not_Strike() {
        frame.bowl(9);
        assertFalse(frame.isNewFrame());
    }

    @Test
    public void isComplete_False_Strike() { //nextFrame.isNewFrame() = false
        frame.bowl(10);
        assertFalse(frame.isNewFrame());
    }

    @Test
    public void isComplete_False_Spare() { //nextFrame.isNewFrame() = false
        frame.bowl(9);
        frame.bowl(1);
        assertFalse(frame.isNewFrame());
    }

    @Test
    public void isComplete_False_Miss() { //nextFrame.isNewFrame() = false
        frame.bowl(8);
        frame.bowl(1);
        assertFalse(frame.isNewFrame());
    }

    @Test
    public void isNewFrame_True_Not_Played() {
        assertTrue(frame.isNewFrame());
    }

    @Test
    public void isNewFrame_False_Played_And_Not_Strike() {
        frame.bowl(9);
        assertFalse(frame.isNewFrame());
    }

    @Test
    public void isNewFrame_True_Played_And_Strike() { //new frame is returned as a result
        frame.bowl(10);
        assertTrue(frame.isNewFrame());
    }
}