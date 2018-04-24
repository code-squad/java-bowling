package status;

import frame.Frame;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SpareTest {
    private Frame frame;

    @Before
    public void setUp() {
        frame = new Frame();
    }

    @Test
    public void 스페어확인() {
        frame.bowl(4);
        State spare = frame.bowl(6);
        assertEquals(spare.isSpare(), true);
    }

    @Test
    public void 출력확인() {
        frame.bowl(4);
        State spare = frame.bowl(6);
        String result = spare.displayText();
        assertEquals("|" + "/ |", result);
    }
}

