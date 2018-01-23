package bowling.domain;

import bowling.util.PinUtil;
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
    public void isOverTenTest() {
        assertThat(pin.isOverTen(new Pin(2))).isTrue();
    }
}
