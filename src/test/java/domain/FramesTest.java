package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FramesTest {
    private Frames frames;

    @Before
    public void setUp() throws Exception {
        frames = new Frames();
    }

    @Test
    public void 몇번째_프레임이세요() {
        /* 프레임 추가하고 점수 추가하고 */
        assertEquals(1, frames.getCurrentFrameNumber());
    }

    /*@Test
    public void 마지막_프레임인가요() {
        assertFalse(frames.isFinishFrame());
    }*/
}
