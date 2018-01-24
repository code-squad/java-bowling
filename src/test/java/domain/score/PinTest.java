package domain.score;

import org.junit.Test;

public class PinTest {

    @Test(expected = IllegalArgumentException.class)
    public void ScoreNumber_음수() throws Exception {
        new Pin(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ScoreNumber_양수() throws Exception {
        new Pin(11);
    }
}