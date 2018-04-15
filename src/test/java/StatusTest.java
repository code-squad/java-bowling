//import game.BowlFrame;
//import game.Status;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class StatusTest {
//    private BowlFrame bowlFrame;
//    private Status status;
//
//    @Before
//    public void setUp() {
//        bowlFrame = new BowlFrame();
//        status = new Status();
//    }
//
//    @Test
//    public void 스트라이크테스트() {
//        boolean result = status.strike(bowlFrame.shot(10));
//        assertTrue(result);
//    }
//
//    @Test
//    public void 진행중테스트() {
//        boolean result = status.onGoing(bowlFrame.shot(7));
//        assertTrue(result);
//    }
//
//    @Test
//    public void 미싱테스트() {
//        bowlFrame.shot(2);
//        boolean result = status.missing(bowlFrame.shot(3));
//        assertTrue(result);
//    }
//
//    @Test
//    public void 스페어테스트() {
//        bowlFrame.shot(7);
//        boolean result = status.spare(bowlFrame.shot(3));
//        assertTrue(result);
//    }
//}
