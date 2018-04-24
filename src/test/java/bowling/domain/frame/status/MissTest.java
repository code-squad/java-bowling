package bowling.domain.frame.status;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MissTest {
    private Status status;

    @Before
    public void setUp() throws Exception {
        status = new Miss(0, 9);
    }

    @Test
    public void bowl_Strike() {
        status = status.bowl(10);
        assertEquals("0|9", status.toString());
    }

    @Test
    public void bowl_PlayedOnce() {
        status = status.bowl(0);
        assertEquals("0|9", status.toString());
    }
}