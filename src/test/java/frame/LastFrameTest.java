package frame;

import frame.LastFrame;
import org.junit.Before;
import org.junit.Test;

public class LastFrameTest {
    private LastFrame lastFrame;

    @Before
    public void setUp() {
        lastFrame = new LastFrame();
    }

    @Test
    public void 마지막프레임시작() {
        lastFrame.shoot(3);
        lastFrame.shoot(7);
    }
}
