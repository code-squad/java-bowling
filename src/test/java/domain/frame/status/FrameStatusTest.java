package domain.frame.status;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrameStatusTest {
    private FrameStatus status;

    @Before
    public void setUp() throws Exception {
        status = FrameStatus.getInitStatus();
    }

    @Test
    public void 스트라이크_문자() {
        status = status.changeStatus(10, 1);
        assertEquals("X", status.convertScore(10));
    }

    @Test
    public void 스패어_문자() {
        status = status.changeStatus(10, 0);
        assertEquals("/", status.convertScore(5));
    }

    @Test
    public void 미쓰_문자() {
        status = status.changeStatus(3, 0);
        assertEquals("3", status.convertScore(3));
    }

    @Test
    public void 진행중_문자() {
        status = status.changeStatus(0, 1);
        assertEquals("-", status.convertScore(0));
    }





    @Test
    public void 스트라이크_정규기록끝() {
        status = status.changeStatus(10, 1);
        assertTrue(status.isFinish());
    }

    @Test
    public void 스패어_정규기록끝() {
        status = status.changeStatus(10, 0);
        assertTrue(status.isFinish());
    }

    @Test
    public void 미쓰_정규기록끝() {
        status = status.changeStatus(3, 0);
        assertTrue(status.isFinish());
    }

    @Test
    public void 진행중_정규기록끝() {
        assertFalse(status.isFinish());
    }

    @Test
    public void 스트라이크_보너스여부() {
        status = status.changeStatus(10, 1);
        assertTrue(status.isBonus());
    }

    @Test
    public void 스패어_보너스여부() {
        status = status.changeStatus(10, 0);
        assertTrue(status.isBonus());
    }

    @Test
    public void 미쓰_보너스여부() {
        status = status.changeStatus(3, 0);
        assertFalse(status.isBonus());
    }

    @Test
    public void 진행중_보너스여부() {
        assertFalse(status.isBonus());
    }

    @Test
    public void 스트라이크로_변경() {
        status = status.changeStatus(10, 1);
        assertTrue(status instanceof Strike);
    }

    @Test
    public void 스패어로_변경() {
        status = status.changeStatus(10, 0);
        assertTrue(status instanceof Spare);
    }

    @Test
    public void 미쓰로_변경() {
        status = status.changeStatus(3, 0);
        assertTrue(status instanceof Miss);
    }

    @Test
    public void 진행중() {
        assertTrue(status instanceof Ing);
    }
}