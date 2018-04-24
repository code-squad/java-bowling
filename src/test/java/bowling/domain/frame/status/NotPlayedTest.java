package bowling.domain.frame.status;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotPlayedTest {
    private Status status;

    @Before
    public void setUp() throws Exception {
        status = new NotPlayed();
    }

    @Test
    public void bowl_Strike() {
        status = status.bowl(10);
        assertEquals("X", status.toString());
    }

    @Test
    public void bowl_PlayedOnce() {
        status = status.bowl(9);
        assertEquals("9", status.toString());
    }
}