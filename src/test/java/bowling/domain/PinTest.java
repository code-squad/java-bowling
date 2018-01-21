package bowling.domain;

import org.junit.Before;
import org.junit.Test;

public class PinTest {
    private Pin pin;

    @Before
    public void init() {
        pin = new Pin(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void excetionTest() {
        new Pin(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionTest_Over10() {
        new Pin(11);
    }
}
