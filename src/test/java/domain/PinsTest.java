package domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PinsTest {
    private Pins pins;

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
    @Test
    public void sumPins() {
        assertThat(Pins.sumPins(new Pins(4), new Pins(5)),is(9));
    }

    @Test
    public void createFirstBowlScore() {
        Pins pins = new Pins(5);
        Score score = pins.createFirstBowlScore(0);
        assertThat(score.toString(),is("score : 5 left : 0"));
    }
}
