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
    public void isOverTenTest() {
        assertThat(pin.isOverTen(new Pin(2))).isTrue();
    }

    @Test()
    public void addTest() {
        assertThat(pin.add(null)).isEqualTo(null);
        assertThat(pin.add(new Pin(10))).isEqualTo(20);
    }

    @Test()
    public void calculateSpareTest() {
        assertThat(pin.calculateSpare()).isEqualTo(20);
    }

    @Test()
    public void toIntValueTest() {
        assertThat(pin.toIntValue()).isEqualTo(10);
    }
}
