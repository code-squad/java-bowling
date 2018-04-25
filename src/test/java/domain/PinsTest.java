package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PinsTest {
    Pins pins;

    @Before
    public void setUp() {
        pins = new Pins(1);
    }

    @Test
    public void generate() {
        pins = new Pins(1);
    }

    @Test
    public void isValid() {
        assertTrue(pins.isValid(1));
    }
}
