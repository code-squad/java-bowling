package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FramesTest {
    Frames frames;

    @Before
    public void setUp() {
        frames = new Frames();
    }

    @Test
    public void createFirstFrame() {
        Frame frame = frames.createFirstFrame();
    }

    @Test
    public void isEmpty() {
        frames.isEmpty();
    }

    @Test
    public void add() {
        Frame frame = frames.createFirstFrame();
        frames.add(frame);
    }

    @Test
    public void equalsFrameCount() {
        Frame frame = frames.createFirstFrame();
        frames.add(frame);
        assertEquals(true, frames.equalsFrameCount(1));
    }
}
