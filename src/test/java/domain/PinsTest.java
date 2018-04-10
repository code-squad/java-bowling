package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PinsTest {
    private Pins pins;

    @Before
    public void setUp() throws Exception {
        pins = new Pins();
    }

    @Test
    public void 점수정상추가() {
        pins.recordPins(4);
        pins.recordPins(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 점수오버추가() {
        pins.recordPins(10);
        pins.recordPins(1);
    }

    @Test
    public void 최대치점수일때_점수추가_더이상할수없다() {
        pins.recordPins(10);
        assertTrue(pins.isFullPinNumRecord());
    }

    @Test
    public void 던진횟수_소진시_점수추가_더이상할수없다() {
        pins.recordPins(5);
        pins.recordPins(3);
        assertTrue(pins.isFullCount());
    }
}
