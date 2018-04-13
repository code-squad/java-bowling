package domain.frame.status;

import domain.frame.pin.Pin;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FrameStatusTest {
    private FrameStatus status;
    private List<Pin> pins;

    @Before
    public void setUp() throws Exception {
        status = FrameStatus.getInitStatus();
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