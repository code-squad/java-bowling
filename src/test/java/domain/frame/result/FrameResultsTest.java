package domain.frame.result;

import domain.frame.Frame;
import org.junit.Before;
import org.junit.Test;
import utils.FrameFactory;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FrameResultsTest {
    private FrameResults results;
    private Frame testFrame;
    private Frame normalFrame;
    private Frame lastFrame;

    @Before
    public void setUp() throws Exception {
        results = new FrameResults();
        testFrame = FrameFactory.of(1);
        normalFrame = FrameFactory.of(1);
        lastFrame = FrameFactory.of(10);
    }

    @Test
    public void 해당프레임_저장된것이_있을때() {
        results.addMessage(testFrame, testFrame.recordPins(10));
        assertTrue(results.isExistRegisteredResult(testFrame));
    }

    @Test
    public void 해당프레임_저장된것이_없을때() {
        assertFalse(results.isExistRegisteredResult(testFrame));
    }

    @Test
    public void 노말프레임_스트라이크_보너스투구후() {
        results.addMessage(normalFrame, normalFrame.recordPins(10));
        results.addMessage(normalFrame, normalFrame.recordPins(10));
        results.addMessage(normalFrame, normalFrame.recordPins(10));
        assertEquals("X", results.getMessage(normalFrame));
    }

    @Test
    public void 노말프레임_스패어_보너스투구후() {
        results.addMessage(normalFrame, normalFrame.recordPins(5));
        results.addMessage(normalFrame, normalFrame.recordPins(5));
        results.addMessage(normalFrame, normalFrame.recordPins(10));
        assertEquals("5|/", results.getMessage(normalFrame));
    }

    @Test
    public void 라스트프레임_스트라이크_보너스투구후() {
        results.addMessage(lastFrame, lastFrame.recordPins(10));
        results.addMessage(lastFrame, lastFrame.recordPins(0));
        results.addMessage(lastFrame, lastFrame.recordPins(10));
        assertEquals("X|-|X", results.getMessage(lastFrame));
    }

    @Test
    public void 라스트프레임_스패어_보너스투구후() {
        results.addMessage(lastFrame, lastFrame.recordPins(5));
        results.addMessage(lastFrame, lastFrame.recordPins(5));
        results.addMessage(lastFrame, lastFrame.recordPins(0));
        assertEquals("5|/|-", results.getMessage(lastFrame));
    }

    @Test(expected = NullPointerException.class)
    public void 노말프레임_점수세팅_미완료() {
        normalFrame.recordPins(10);
        normalFrame.recordPins(10);
        results.addScore(normalFrame, normalFrame.getScore());
        results.getScore(normalFrame);
    }

    @Test
    public void 노말프레임_점수세팅_완료() {
        normalFrame.recordPins(10);
        normalFrame.recordPins(10);
        normalFrame.recordPins(10);
        results.addScore(normalFrame, normalFrame.getScore());
        assertEquals(30, results.getScore(normalFrame).getScore());
    }

    @Test(expected = NullPointerException.class)
    public void 라스트레임_점수세팅_미완료() {
        lastFrame.recordPins(5);
        lastFrame.recordPins(5);
        results.addScore(lastFrame, lastFrame.getScore());
        results.getScore(lastFrame);
    }

    @Test
    public void 라스트프레임_점수세팅_완료() {
        lastFrame.recordPins(5);
        lastFrame.recordPins(5);
        lastFrame.recordPins(10);
        results.addScore(lastFrame, lastFrame.getScore());
        assertEquals(20, results.getScore(lastFrame).getScore());
    }
}
