//package frame;
//
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FrameManagerTest {
//    private List<Frame> frames;
//    private FrameManager xframe;
//
//    @Before
//    public void setUp() {
//        frames = new ArrayList<>();
//        xframe = new FrameManager();
//    }
//
//    @Test
//    public void 스트라이크테스트() {
//        Frame result = xframe.onFrame(10);
//        int num = result.getFirstPin().getPinFall();
//        assertEquals(10, num);
//    }
//}
