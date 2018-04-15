import game.Frame;
import game.Pin;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PinTest {
    private Pin pin;
    private Frame frame;

    @Before
    public void setUp() {
        pin = new Pin(0);
        frame = new Frame();
    }

    @Test(expected = IllegalArgumentException.class)
    public void MAX초과테스트() {
        pin = new Pin(11);
    }

    @Test
    public void 프레임끝() {
        pin = new Pin(10);
        boolean result = pin.checkFinish();
        assertTrue(result);
    }

    @Test
    public void checkFinish() {
        Pin firstPin = new Pin(10);
        boolean result = firstPin.checkFinish();
        assertTrue(result);
    }

    @Test
    public void 프레임아직안끝남() {
        pin = new Pin(8);
        boolean result = pin.checkFinish();
        assertFalse(result);
    }

    @Test
    public void 프레임2번만에끝내기() {
        frame.shootFirstPin(8);
        frame.shootSecondPin(4);
        boolean result = frame.finishFrame();
        assertTrue(result);
    }
}
