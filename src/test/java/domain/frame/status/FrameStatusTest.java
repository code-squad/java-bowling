package domain.frame.status;

import domain.frame.Frame;
import domain.frame.pin.Pin;
import domain.frame.result.CannotCalcException;
import domain.frame.result.Score;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrameStatusTest {
    private FrameStatus status;
    private Frame normalFrame;
    private Frame lastFrame;

    @Before
    public void setUp() throws Exception {
        status = new Ready();
        normalFrame = Frame.of(1);
        lastFrame = Frame.of(10);
    }

    @Test
    public void 상태변화_스트라이크_노말프레임() {
        status = status.roll(normalFrame, new Pin(10));
        assertTrue(status.isFinish(normalFrame));
    }

    @Test
    public void 상태변화_스트라이크_라스트프레임() {
        status = status.roll(lastFrame, new Pin(10));
        assertFalse(status.isFinish(lastFrame));
    }

    @Test
    public void 상태변화_스패어_노말프레임() {
        status = status.roll(normalFrame, new Pin(5));
        status = status.roll(normalFrame, new Pin(5));
        assertTrue(status.isFinish(normalFrame));
    }

    @Test
    public void 상태변화_스패어_라스트프레임() {
        status = status.roll(lastFrame, new Pin(5));
        status = status.roll(lastFrame, new Pin(5));
        assertFalse(status.isFinish(lastFrame));
    }

    @Test
    public void 상태변화_미쓰_노말프레임() {
        status = status.roll(normalFrame, new Pin(3));
        status = status.roll(normalFrame, new Pin(5));
        assertTrue(status.isFinish(normalFrame));
    }

    @Test
    public void 상태변화_미쓰_라스트프레임() {
        status = status.roll(lastFrame, new Pin(3));
        status = status.roll(lastFrame, new Pin(5));
        assertTrue(status.isFinish(lastFrame));
    }

    @Test
    public void 상태변화_진행중_노말프레임() {
        status = status.roll(normalFrame, new Pin(2));
        assertFalse(status.isFinish(normalFrame));
    }

    @Test
    public void 상태변화_진행중_라스트프레임() {
        status = status.roll(lastFrame, new Pin(9));
        assertFalse(status.isFinish(lastFrame));
    }


    /* TODO : 라스트프레임 상태 변화 테스트 해야함 */


    @Test
    public void 상태메세지_스트라이크_노말프레임() {
        status = status.roll(normalFrame, new Pin(10));
        assertEquals("X", status.getResultMessage());
    }

    @Test
    public void 상태메세지_스트라이크_라스트프레임() {
        status = status.roll(lastFrame, new Pin(10));
        assertEquals("X", status.getResultMessage());
    }

    @Test
    public void 상태메세지_스패어_노말프레임() {
        status = status.roll(normalFrame, new Pin(3));
        status = status.roll(normalFrame, new Pin(7));
        assertEquals("3|/", status.getResultMessage());
    }

    @Test
    public void 상태메세지_스패어_라스트프레임() {
        status = status.roll(normalFrame, new Pin(3));
        status = status.roll(normalFrame, new Pin(7));
        assertEquals("3|/", status.getResultMessage());
    }

    @Test
    public void 상태메세지_미쓰_노말프레임() {
        status = status.roll(normalFrame, new Pin(2));
        status = status.roll(normalFrame, new Pin(4));
        assertEquals("2|4", status.getResultMessage());
    }

    @Test
    public void 상태메세지_미쓰_라스트프레임() {
        status = status.roll(normalFrame, new Pin(6));
        status = status.roll(normalFrame, new Pin(0));
        assertEquals("6|-", status.getResultMessage());
    }

    @Test
    public void 상태메세지_진행중_노말프레임() {
        status = status.roll(normalFrame, new Pin(0));
        assertEquals("-", status.getResultMessage());
    }

    @Test
    public void 상태메세지_진행중_라스트프레임() {
        status = status.roll(normalFrame, new Pin(4));
        assertEquals("4", status.getResultMessage());
    }



    /* TODO : 라스트 프레임 상태메세지 추가해야함 */



    @Test(expected = CannotCalcException.class)
    public void 노말프레임_스트라이크_대기상태프레임에게_점수_건네받기() {
        status = status.roll(normalFrame, new Pin(10));
        FrameStatus otherStatus = new Ready();
        otherStatus.addBonusScore(status.getScore());
    }

    @Test
    public void 노말프레임_스트라이크_스패어상태프레임에게_점수_건네받기() {
        status = status.roll(normalFrame, new Pin(10));
        FrameStatus otherStatus = new Spare(new Pin(3), new Pin(7));
        Score totalScore = otherStatus.addBonusScore(status.getScore());
        assertEquals(20, totalScore.get());
    }

    @Test(expected = CannotCalcException.class)
    public void 노말프레임_스패어_대기상태프레임에게_점수_건네받기() {
        status = status.roll(normalFrame, new Pin(7));
        status = status.roll(normalFrame, new Pin(3));
        FrameStatus otherStatus = new Ready();
        otherStatus.addBonusScore(status.getScore());
    }

    @Test
    public void 노말프레임_스패어_스패어상태프레임에게_점수_건네받기() {
        status = status.roll(normalFrame, new Pin(7));
        status = status.roll(normalFrame, new Pin(3));
        FrameStatus otherStatus = new Spare(new Pin(6), new Pin(4));
        Score totalScore = otherStatus.addBonusScore(status.getScore());
        assertEquals(16, totalScore.get());
    }





    /* TODO : 여기부터 만들어야함 */
    @Test(expected = CannotCalcException.class)
    public void 라스트프레임_스트라이크_추가점수없이_보너스점수_합산하기() {
        status = status.roll(lastFrame, new Pin(10));
        Score score = status.getScore();
        score.get();
    }
}