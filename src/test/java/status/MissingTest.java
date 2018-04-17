package status;

import game.Pin;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MissingTest {
    private Missing missing;

    @Before
    public void setUp() {
        missing = new Missing(new Pin(3), new Pin(5));
    }

    @Test
    public void 미싱확인() {
        boolean result = missing.checkMissing();
        assertTrue(result);
    }

    @Test
    public void 미싱기호확인() {
        String str = missing.toString();
        assertEquals("-", str);
    }
}
