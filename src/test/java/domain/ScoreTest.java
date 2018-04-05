package domain;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ScoreTest {

    @Test
    public void 유효한_범위() {
        assertTrue(Score.isValidRange(10));
    }

    @Test
    public void 유효하지않은_범위() {
        assertFalse(Score.isValidRange(11));
    }
}
