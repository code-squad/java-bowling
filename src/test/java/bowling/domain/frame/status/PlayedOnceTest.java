package bowling.domain.frame.status;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayedOnceTest {
    private Status status;

    @Before
    public void setUp() throws Exception {
        status = new PlayedOnce(8);
    }

    @Test
    public void bowl_Spare() {
        status = status.bowl(2);
        assertEquals("8|/", status.toString());
    }

    @Test
    public void bowl_Miss() {
        status = status.bowl(1);
        assertEquals("8|1", status.toString());
    }
}