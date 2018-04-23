package domain.frame.status;

import domain.frame.pin.Pin;
import domain.frame.result.Score;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrameStatusTest {
    private FrameStatus status;

    @Before
    public void setUp() throws Exception {
        status = new Ready();
    }

    @Test
    public void 상태변화_스트라이크() {
        status = status.roll(new Pin(10));
        assertTrue(status.isFinish());
    }

    @Test
    public void 상태변화_스패어() {
        status = status.roll(new Pin(5));
        status = status.roll(new Pin(5));
        assertTrue(status.isFinish());
    }

    @Test
    public void 상태변화_미쓰() {
        status = status.roll(new Pin(3));
        status = status.roll(new Pin(5));
        assertTrue(status.isFinish());
    }

    @Test
    public void 상태변화_진행중() {
        status = status.roll(new Pin(2));
        assertFalse(status.isFinish());
    }

    @Test
    public void 상태메세지_스트라이크() {
        status = status.roll(new Pin(10));
        assertEquals("X", status.getResultMessage());
    }

    @Test
    public void 상태메세지_스패어() {
        status = status.roll(new Pin(3));
        status = status.roll(new Pin(7));
        assertEquals("3|/", status.getResultMessage());
    }

    @Test
    public void 상태메세지_미쓰_노말프레임() {
        status = status.roll(new Pin(2));
        status = status.roll(new Pin(4));
        assertEquals("2|4", status.getResultMessage());
    }

    @Test
    public void 상태메세지_진행중_노말프레임() {
        status = status.roll(new Pin(0));
        assertEquals("-", status.getResultMessage());
    }

    @Test
    public void 스패어_스패어상태프레임에게_점수_건네받기() {
        status = status.roll(new Pin(7));
        status = status.roll(new Pin(3));
        FrameStatus otherStatus = new Spare(new Pin(6), new Pin(4));
        Score totalScore = otherStatus.addBonusScore(status.getScore());
        assertEquals(16, totalScore.get());
    }

    @Test(expected = CannotCalcException.class)
    public void 스트라이크_추가점수없이_보너스점수_합산하기() {
        status = status.roll(new Pin(10));
        Score score = status.getScore();
        score.get();
    }

    @Test(expected = CannotCalcException.class)
    public void 스패어_추가점수없이_보너스점수_합산하기() {
        status = status.roll(new Pin(5));
        status = status.roll(new Pin(5));
        Score score = status.getScore();
        score.get();
    }
}