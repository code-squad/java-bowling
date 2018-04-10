package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PinTest {

    @Test
    public void 유효한_범위() {
        assertTrue(Pin.isValidRange(10));
    }

    @Test
    public void 유효하지않은_범위() {
        assertFalse(Pin.isValidRange(11));
    }

    @Test
    public void 합산점수_최대치인가() {
        List<Pin> pins = Arrays.asList(new Pin(5), new Pin(5));
        assertTrue(Pin.isFullPinNumRecord(pins));
    }

    @Test
    public void 합산점수_최대치인가2() {
        List<Pin> pins = Arrays.asList(new Pin(2), new Pin(7));
        assertFalse(Pin.isFullPinNumRecord(pins));
    }
}
