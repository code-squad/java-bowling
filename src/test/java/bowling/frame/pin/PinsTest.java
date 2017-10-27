package bowling.frame.pin;

import static org.junit.Assert.*;

import org.junit.Test;

public class PinsTest {
    @Test(expected = IllegalArgumentException.class)
    public void createWhenOverMaxPins() throws Exception {
        Pins.bowl(11);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void createWhenUnderMinPins() throws Exception {
        Pins.bowl(-1);
    }
    
    @Test
    public void strike() throws Exception {
        Pins pins = Pins.bowl(10);
        assertTrue(pins.isStrike());
    }
    
    @Test
    public void spare() throws Exception {
        Pins pins = Pins.bowl(8);
        assertTrue(pins.isSpare(Pins.bowl(2)));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void spareWhenOverMaxPins() throws Exception {
        Pins pins = Pins.bowl(8);
        pins.isSpare(Pins.bowl(3));
    }
    
    @Test
    public void miss() throws Exception {
        Pins pins = Pins.bowl(8);
        assertTrue(pins.isMiss(Pins.bowl(1)));
    }
}
