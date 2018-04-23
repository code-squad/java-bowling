//package status;
//import game.Pin;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class NormalTest {
//    private Normal normal;
//
//    @Before
//    public void setUp() {
//        normal = new Normal(new Pin(7), new Pin(2));
//    }
//
//    @Test
//    public void 노말상태테스트() {
//        boolean result = normal.checkNormal();
//        assertTrue(result);
//    }
//
//    @Test
//    public void 노말에서스페어() {
//        normal = new Normal(new Pin(2), new Pin(8));
//        boolean result = normal.checkNormal();
//        assertFalse(result);
//    }
//
//    @Test
//    public void 노말에서미싱() {
//        normal = new Normal(new Pin(2), new Pin(0));
//        boolean result = normal.checkNormal();
//        assertFalse(result);
//    }
//}
