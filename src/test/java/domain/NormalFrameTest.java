//package domain;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//public class NormalFrameTest {
//    NormalFrame normalFrame;
//
//    @Before
//    public void setup() {
////        normalFrame = new NormalFrame("htw");
//        normalFrame = new NormalFrame();
//    }
//
//    @Test
//    public void firstThrowing() {
//        assertTrue(normalFrame.isFirst());
//    }
//
//    @Test
//    public void secondThrowing() {
//        normalFrame.throwing(new Pin(1));
//        assertTrue(normalFrame.isSecond());
//    }
//
//    @Test
//    public void firstThrowingPins() {
//        assertEquals(6, normalFrame.throwing(new Pin(4)));
//    }
//
//    @Test
//    public void secondThrowingPins() {
//        normalFrame.throwing(new Pin(4)); // 남은 핀 6개
//        assertEquals(1, normalFrame.throwing(new Pin(5)));
//    }
//
//    @Test
//    public void setStrikeStatus() {
//        normalFrame = new NormalFrame(10,0);
//        assertEquals(Status.STRIKE, normalFrame.createStatus());
//    }
//
//    @Test
//    public void isStatus() {
//        normalFrame.throwing(new Pin(7));
//        normalFrame.throwing(new Pin(3));
//        assertTrue(normalFrame.isStatus(Status.SPARE));
//    }
//}
