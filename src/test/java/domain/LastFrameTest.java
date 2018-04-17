package domain;

import org.junit.Test;

public class LastFrameTest {
    @Test
    public void throwing() {
        LastFrame lastFrame = new LastFrame(10);
        lastFrame.throwing(9);
    }
}
