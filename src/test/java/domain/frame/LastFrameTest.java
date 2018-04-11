package domain.frame;

import domain.frame.result.score.FrameScore;
import org.junit.Before;
import org.junit.Test;
import utils.FrameFactory;

import static org.junit.Assert.*;

public class LastFrameTest {
    private Frame lastFrame;

    @Before
    public void setUp() throws Exception {
        lastFrame = FrameFactory.of(Frames.LIMIT_NUM);
    }

    @Test
    public void 보너스상황() {
        lastFrame.recordPins(10);
        assertTrue(lastFrame.isRegularRecordFinish());
    }

    @Test
    public void 스트라이크_보너스투구_미완료() {
        lastFrame.recordPins(10);
        lastFrame.recordPins(10);
        assertFalse(lastFrame.isFinish());
    }

    @Test
    public void 스트라이크_보너스투구_완료() {
        lastFrame.recordPins(10);
        assertTrue(lastFrame.isRegularRecordFinish());
    }

    @Test
    public void 스트라이크_보너스투구_토탈점수() {
        lastFrame.recordPins(10);
        lastFrame.recordPins(10);
        lastFrame.recordPins(5);
        assertEquals(25, lastFrame.getScore().getScore());
    }

    @Test
    public void 스패어_보너스투구_미완료() {
        lastFrame.recordPins(5);
        lastFrame.recordPins(5);
        assertFalse(lastFrame.isFinish());
    }

    @Test
    public void 스패어_보너스투구_완료() {
        lastFrame.recordPins(5);
        lastFrame.recordPins(5);
        lastFrame.recordPins(0);
        assertEquals(10, lastFrame.getScore().getScore());
    }

    @Test
    public void 스트라이크_보너스10점_결과() {
        lastFrame.recordPins(10);

    }

    @Test
    public void 스트라이크_보너스0점_결과() {
        lastFrame.recordPins(10);

    }

    @Test
    public void 스패어_보너스10점_결과() {
        lastFrame.recordPins(5);
        lastFrame.recordPins(5);
    }

    @Test
    public void 스패어_보너스0점_결과() {
        lastFrame.recordPins(5);

        //assertEquals("-", lastFrame.recordBonusPins(0));
    }
}