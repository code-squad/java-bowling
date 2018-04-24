package frame;

import frame.LastFrame;
import org.junit.Before;
import org.junit.Test;
import status.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LastFrameTest {
    private LastFrame lastFrame;

    @Before
    public void setUp() {
        lastFrame = new LastFrame();
    }

    @Test
    public void 첫번째샷테스트1() {
        lastFrame.bowl(5);
        boolean result = lastFrame.getStates().get(0).isFirstBowl();
        assertEquals(result, true);
    }

    @Test
    public void 두번째샷스페어() {
        lastFrame.bowl(5);
        lastFrame.bowl(5);
        boolean result = lastFrame.getStates().get(1).isSpare();
        assertEquals(result, true);
    }

    @Test
    public void 두번째샷미스() {
        lastFrame.bowl(5);
        lastFrame.bowl(0);
        boolean result = lastFrame.getStates().get(1).isMiss();
        assertEquals(result, true);
    }

    @Test
    public void 스트라이크연속2번() {
        List<State> states = lastFrame.bowl(10);
        lastFrame.bowl(10);
        System.out.println(lastFrame.getStates());
    }

    @Test
    public void 스트라이크연속3번() {
        List<State> states = lastFrame.bowl(10);
        lastFrame.bowl(10);
        lastFrame.bowl(10);
        System.out.println(lastFrame.getStates());
    }
}
