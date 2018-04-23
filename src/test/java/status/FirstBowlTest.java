package status;

import org.junit.Test;

import static org.junit.Assert.*;

public class FirstBowlTest {
    @Test
    public void 첫번째샷테스트() {
        FirstBowl firstBowl = new FirstBowl(6);
        String result = firstBowl.displayText();
        assertEquals("  6", result);
    }
}
