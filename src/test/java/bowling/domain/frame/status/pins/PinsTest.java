package bowling.domain.frame.status.pins;

import org.junit.Test;

import static org.junit.Assert.*;

public class PinsTest {
    private Pins pins;

    @Test (expected = IllegalArgumentException.class)
    public void ofFirstBowl_Over_Max_Value() {
        pins = Pins.ofFirstBowl(11);
    }

    @Test (expected = IllegalArgumentException.class)
    public void ofFirstBowl_Under_Min_Value() {
        pins = Pins.ofFirstBowl(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void ofSecondBowl_More_Than_Pins_That_Were_Left() {
        pins = Pins.ofSecondBowl(9, 2);
    }
}