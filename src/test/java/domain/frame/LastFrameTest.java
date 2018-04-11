package domain.frame;

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
    public void 스트라이크_보너스투구_미완료_점수조회() {
        lastFrame.recordPins(10);
        assertNull(lastFrame.getScore());
    }

    @Test
    public void 스트라이크_보너스투구_완료_점수조회() {
        lastFrame.recordPins(10);
        lastFrame.recordPins(10);
        lastFrame.recordPins(0);
        assertEquals(20, lastFrame.getScore().getScore());
    }

    @Test
    public void 스패어_보너스투구_미완료_점수조회() {
        lastFrame.recordPins(5);
        lastFrame.recordPins(5);
        assertNull(lastFrame.getScore());
    }

    @Test
    public void 스패어_보너스투구_완료_점수조회() {
        lastFrame.recordPins(5);
        lastFrame.recordPins(5);
        lastFrame.recordPins(10);
        assertEquals(20, lastFrame.getScore().getScore());
    }

    @Test
    public void 미쓰_점수조회() {
        lastFrame.recordPins(5);
        lastFrame.recordPins(4);
        assertEquals(9, lastFrame.getScore().getScore());
    }

    @Test
    public void 진행중_점수조회() {
        lastFrame.recordPins(5);
        assertNull(lastFrame.getScore());
    }
}