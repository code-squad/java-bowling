//package game;
//
//import frame.Game;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class PinTest {
//    private Pin pin;
//    private Game frame;
//
//    @Before
//    public void setUp() {
//        pin = new Pin(0);
//        frame = new Game();
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void MAX초과테스트() {
//        pin = new Pin(11);
//    }
//
//    @Test
//    public void 프레임끝() {
//        pin = new Pin(10);
//        boolean result = pin.checkFinish();
//        assertTrue(result);
//    }
//
//    @Test
//    public void checkFinish() {
//        Pin firstPin = new Pin(10);
//        boolean result = firstPin.checkFinish();
//        assertTrue(result);
//    }
//}
