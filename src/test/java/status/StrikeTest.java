package status;

import frame.Frame;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StrikeTest {
    private Frame frame;

    @Before
    public void setUp() {
        frame = new Frame();
    }

    @Test
    public void 스트라이크확인() {
        State strike = frame.bowl(10);
        assertEquals(strike instanceof Strike, true);
    }

    @Test
    public void 문자확인() {
        State strike = frame.bowl(10);
        String result = strike.displayText();
        assertEquals("  X   |" , result);
    }
}
