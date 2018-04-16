package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PinsTest {
    Pins pins;
    Pins firstPins;
    Pins secondPins;

    @Before
    public void setup() {

    }

    @Test
    public void createPins() {
         pins = new Pins(5);
    }

    @Test
    public void isStrike() {
        firstPins = new Pins(10);
        assertTrue(firstPins.isStrike());
    }

    @Test
    public void isSpare() {
        firstPins = new Pins(5);
        secondPins = new Pins(5);
        assertTrue(firstPins.isSpare(secondPins));
    }

    @Test
    public void isOpen() {
        firstPins = new Pins(6);
        secondPins = new Pins(3);
        assertTrue(firstPins.isOpen(secondPins));
    }

}
