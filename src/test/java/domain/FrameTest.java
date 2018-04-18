package domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FrameTest {
    private Frame frame;

    @Test
    public void frameNoValidationPass() {
        frame = new NormalFrame(1);
        assertTrue(frame.isValidNo(1));
    }

    @Test(expected = RuntimeException.class)
    public void frameNoValidationFail1() {
        frame = new NormalFrame(1);
        frame.isValidNo(11);
    }

    @Test(expected = RuntimeException.class)
    public void frameNoValidationFail2() {
        frame = new NormalFrame(1);
        frame.isValidNo(-1);
    }

    @Test
    public void generateLastFrame() {
        Frame normalFrame = new NormalFrame(9);
        Frame lastFrame = normalFrame.next();
        assertTrue(lastFrame instanceof LastFrame);
    }
}
