import game.Frame;
import game.Pin;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FrameTest {
    private Frame frame;
    private Pin firstPin;
    private Pin secondPin;

    @Before
    public void setUp() {
        frame = new Frame();
    }

    @Test
    public void 첫번째샷() {
        firstPin = new Pin(8);
        System.out.println(firstPin.getPinFall());
    }

    @Test
    public void 두번째샷() {
        frame.shootFirstPin(8);
        frame.shootSecondPin(2);
    }



    @Test
    public void 프레임끝() {
        Pin firstPin = new Pin(8);
        Pin secondPin = new Pin(2);
        boolean result = frame.finishFrame();
        assertTrue(result);
    }
}
