//import frame.Frame;
//import game.Result;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class ResultTest {
//    private Result result;
//
//    @Before
//    public void setUp() {
//       Game frame = new Game();
//       frame.shoot(3);
//       frame.shoot(7);
//       result = new Result(frame.checkStatus(), frame);
//    }
//
//    @Test
//    public void 결과테스트() {
//        int num =result.getFrame().getFirstPin().getPinFall();
//        assertEquals(3, num);
//    }
//
//    @Test
//    public void 상태테스트() {
//        String str = result.getStatus().toString();
//        assertEquals("/ ", str);
//    }
//}
