package bowling.domain;

import org.junit.Before;
import org.junit.Test;

public class NormalFrameTest {
    private NormalFrame normalFrame;

    @Before
    public void init() {
        normalFrame = new NormalFrame(new FinalFrame());
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest() {
        new NormalFrame(null);
    }
}
