package status;

import frame.Frame;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstBowlTest {
    @Test
    public void 첫번째샷테스트() {
        FirstBowl firstBowl = new FirstBowl(6);
        String result = firstBowl.displayText();
        assertEquals("  6", result);
    }

    @Test
    public void checkFirstBowl() {
        Frame frame = new Frame();
        State state = frame.bowl(6);
        boolean result = state.isFirstBowl();
        assertEquals(result, true);
    }
}
