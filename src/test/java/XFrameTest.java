import game.Frame;
import game.XFrame;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class XFrameTest {
    private List<Frame> frames;
    private XFrame xframe;

    @Before
    public void setUp() {
        frames = new ArrayList<>();
        xframe = new XFrame();
    }

    @Test
    public void 스트라이크테스트() {
        boolean result = xframe.onFrame(10);
        System.out.println("size of frames is " + xframe.getFrames().size());
        System.out.println("firstPin is " + xframe.getFrames().get(0).getFirstPin().getPinFall());
    }

    @Test
    public void 플레이프레임테스트() {
        boolean result = xframe.onFrame(3);
        System.out.println("size of frames is " + xframe.getFrames().size());
        System.out.println("firstPin is " + xframe.getFrames().get(0).getFirstPin().getPinFall());
        System.out.println("secondPin is " + xframe.getFrames().get(0).getSecondPin().getPinFall());
        assertTrue(result);
    }
}
