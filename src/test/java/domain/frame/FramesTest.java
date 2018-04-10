package domain.frame;

import domain.frame.result.FrameMessages;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FramesTest {
    private FrameMessages results;
    private Frames frames;

    @Before
    public void setUp() throws Exception {
        results = new FrameMessages();
        frames = new Frames();
    }

    @Test
    public void 이번턴_프레임넘버1() {
        frames.recordPins(5);
        assertEquals(1, frames.getCurrentFrameNum());
    }

    @Test
    public void 이번턴_프레임넘버2() {
        frames.recordPins(10);
        assertEquals(2, frames.getCurrentFrameNum());
    }
}
