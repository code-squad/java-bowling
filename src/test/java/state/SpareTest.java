package state;

import domain.Pins;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpareTest {
    @Test
    public void generate() {
        Pins first = new Pins(5);
        Pins second = new Pins(5);
        if (!first.isSpare(second)) {
            throw new IllegalArgumentException("Spare 상태 생성 불가");
        }
        State state = new Spare(first);
    }

    @Test
    public void print() {
        Pins first = new Pins(5);
        Pins second = new Pins(5);
        if (!first.isSpare(second)) {
            throw new IllegalArgumentException("Spare 상태 생성 불가");
        }
        State state = new Spare(first);
        assertEquals("5|/", state.printState());
    }
}
