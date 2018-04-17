package status;

import game.Pin;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StrikeTest {
    private Strike strike;
    @Before
    public void setUp() {
        strike = new Strike(new Pin(10));
    }

    @Test
    public void 스트라이크확인() {
        boolean result = strike.checkStrike();
        assertTrue(result);
    }

    @Test
    public void 스트라이크문자출력() {
        String str = strike.toString();
        assertEquals("X", str);
    }
}
