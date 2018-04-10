package domain.frame.status;

import domain.Pins;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FrameStatusTest {
    private FrameStatus status;
    private Pins pins;

    @Before
    public void setUp() throws Exception {
        pins = new Pins();
        status = FrameStatus.getInitStatus();
    }

    @Test
    public void 프레임_상태_진행중() {
        assertFalse(status.isFinish());
    }

    @Test
    public void 프레임_상태_스트라이크() {
        pins.recordPins(10);
        status = status.changeStatus(pins);
        assertTrue(status.isFinish() && status.isBonus());
    }

    @Test
    public void 프레임_상태_스페어() {
        pins.recordPins(3);
        pins.recordPins(7);
        status = status.changeStatus(pins);
        assertTrue(status.isFinish() && status.isBonus());
    }

    @Test
    public void 프레임_상태_미쓰() {
        pins.recordPins(6);
        pins.recordPins(2);
        status = status.changeStatus(pins);
        assertTrue(status.isFinish() && !status.isBonus());
    }

    @Test
    public void 스트라이크_보너스카운트() {
        pins.recordPins(10);
        status = status.changeStatus(pins);
        assertEquals(2, status.getBonusCount());
    }

    @Test
    public void 스페어_보너스카운트() {
        pins.recordPins(3);
        pins.recordPins(7);
        status = status.changeStatus(pins);
        assertEquals(1, status.getBonusCount());
    }

    @Test
    public void 미쓰_보너스카운트() {
        pins.recordPins(6);
        pins.recordPins(2);
        status = status.changeStatus(pins);
        assertEquals(0, status.getBonusCount());
    }
}