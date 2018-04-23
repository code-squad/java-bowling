//package frame;
//
//import frame.Game;
//import org.junit.Before;
//import org.junit.Test;
//import status.Status;
//import status.Strike;
//
//import static org.junit.Assert.*;
//
//public class FrameTest {
//    private Game frame;
//
//    @Before
//    public void setUp() {
//        frame = new Game();
//    }
//
//    @Test
//    public void 공굴리기1() {
//        frame.shoot(2);
//        frame.shoot(8);
//        System.out.println("first pin is " + frame.getFirstPin().getPinFall() + " on test method");
//        System.out.println("second pin is " + frame.getSecondPin().getPinFall() + " on test method");
//    }
//
//    @Test
//    public void 프레임스트라이크() {
//        frame.shoot(10);
//        boolean result = frame.finishFrame();
//        assertTrue(result);
//    }
//
//    @Test
//    public void 프레임안끝남() {
//        frame.shoot(3);
//        boolean result = frame.finishFrame();
//        assertFalse(result);
//    }
//
//    @Test
//    public void 프레임끝() {
//        frame.shoot(3);
//        frame.shoot(6);
//        boolean result = frame.finishFrame();
//        assertTrue(result);
//    }
//
//    @Test
//    public void 상태값테스트스트라이크리턴() {
//        frame.shoot(4);
//        frame.shoot(6);
//        Status status = frame.checkStatus();
//    }
//}
