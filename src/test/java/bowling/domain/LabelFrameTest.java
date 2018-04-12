package bowling.domain;

import bowling.domain.frame.LabelFrame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LabelFrameTest {
    private LabelFrame frame;

    @Before
    public void setUp() throws Exception {
        frame = new LabelFrame(5);
    }

    @Test
    public void toStringTest() {
        assertEquals("05", frame.toString());
    }
}