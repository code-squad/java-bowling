package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PinTest {
    private Pin pin;

    @Before
    public void init() {
        pin = new Pin(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionTest() {
        new Pin(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionTest_Over10() {
        new Pin(11);
    }

    @Test()
    public void getNumOfPinTest() {
        assertThat(Pin.getNumOfPin(new Pin(10))).isEqualTo(10);
    }
}
