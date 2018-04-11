package domain.frame;

import domain.frame.result.FrameResults;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FramesTest {
    private Frames frames;
    private FrameResults results;

    @Before
    public void setUp() throws Exception {
        frames = new Frames();
        results = new FrameResults();
    }

    @Test
    public void 이번턴_프레임넘버1() {
        frames.recordPins(results, 5);
        assertEquals(1, frames.getCurrentFrameNum());
    }

    @Test
    public void 이번턴_프레임넘버2() {
        frames.recordPins(results, 10);
        assertEquals(2, frames.getCurrentFrameNum());
    }
}
