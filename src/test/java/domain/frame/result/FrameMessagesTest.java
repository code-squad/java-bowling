package domain.frame.result;

import domain.frame.Frame;
import utils.FrameFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrameMessagesTest {
    private FrameMessages results;

    @Before
    public void setUp() throws Exception {
        results = new FrameMessages();
    }

    @Test
    public void 같은_프레임_결과_채우기() {
        Frame frame = FrameFactory.of(1);
        results.addFrameMessage(0, frame.convertPinNum(5));
        results.addFrameMessage(0, frame.convertPinNum(4));
        assertEquals(1, results.getRegisteredSize());
    }

    @Test
    public void 다른_프레임_결과_채우기() {
        Frame frame1 = FrameFactory.of(1);
        Frame frame2 = FrameFactory.of(2);
        results.addFrameMessage(0, frame1.convertPinNum(5));
        results.addFrameMessage(1, frame2.convertPinNum(3));
        assertEquals(2, results.getRegisteredSize());
    }
}