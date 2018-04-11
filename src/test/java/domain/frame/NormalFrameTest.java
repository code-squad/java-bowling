package domain.frame;

import org.junit.Before;
import org.junit.Test;
import utils.FrameFactory;

import static org.junit.Assert.*;

public class NormalFrameTest {
    private Frame currentFrame;

    @Before
    public void setUp() throws Exception {
        currentFrame = FrameFactory.of(1);
    }

    @Test
    public void 프레임_점수_추가() {
        currentFrame.recordPins(5);
        currentFrame.recordPins(5);
    }

    @Test
    public void 프레임_종료_체크() {
        assertFalse(currentFrame.isFinish());
    }

    @Test
    public void 스트라이크_결과() {
        assertEquals("X", currentFrame.recordPins(10));
    }

    @Test
    public void 스패어_결과() {
        currentFrame.recordPins(3);
        assertEquals("/", currentFrame.recordPins(7));
    }

    @Test
    public void 미쓰_결과() {
        currentFrame.recordPins(1);
        assertEquals("5", currentFrame.recordPins(5));
    }

    @Test
    public void 미쓰_0점_포함_결과() {
        currentFrame.recordPins(5);
        assertEquals("-", currentFrame.recordPins(0));
    }

    @Test
    public void 진행중_결과() {
        assertEquals("5", currentFrame.recordPins(5));
    }

    @Test
    public void 보너스상황() {
        currentFrame.recordPins(10);
        assertTrue(currentFrame.isBonus());
    }

    @Test
    public void 스트라이크_보너스투구_미완료() {
        currentFrame.recordPins(10);
        assertFalse(currentFrame.isBonusFinish());
    }

    @Test
    public void 스트라이크_보너스투구_완료() {
        currentFrame.recordPins(10);
        currentFrame.recordPins(10);
        currentFrame.recordPins(0);
        assertTrue(currentFrame.isFinish());
    }

    @Test
    public void 스패어_보너스투구_미완료() {
        currentFrame.recordPins(5);
        currentFrame.recordPins(5);
        assertFalse(currentFrame.isBonusFinish());
    }

    @Test
    public void 스패어_보너스투구_완료() {
        currentFrame.recordPins(5);
        currentFrame.recordPins(5);
        currentFrame.recordPins(10);
        assertTrue(currentFrame.isBonusFinish());
    }
}