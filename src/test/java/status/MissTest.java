package status;

import frame.Frame;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MissTest {
    private Frame frame;

    @Before
    public void setUp() {
        frame = new Frame();
    }

    @Test
    public void 미싱확인() {
        frame.bowl(4);
        State miss = frame.bowl(4);
        assertEquals(miss instanceof Miss, true);
    }

    @Test
    public void 출력확인() {
        frame.bowl(4);
        String result = frame.bowl(4).displayText();
        assertEquals("|4 |", result);
    }
}
