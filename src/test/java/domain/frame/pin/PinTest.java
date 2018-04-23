package domain.frame.pin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PinTest {

    @Test
    public void 유효한값() {
        assertEquals(10, new Pin(10).getNum());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 유효하지않은값() {
        new Pin(11).getNum();
    }
}