package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class LastFrameTest {
    private Frame frame;

    @Test
    public void toStringTest_Strike() {
        frame = new LastFrame(10, 0, 10);
        String oneFrame = frame.toString();
        assertEquals("X| |X", oneFrame);
    }

    @Test
    public void toStringTest_Spare() {
        frame = new LastFrame(8, 2, 8);
        String oneFrame = frame.toString();
        assertEquals("8|/|8", oneFrame);
    }

    @Test
    public void toStringTest_Normal() {
        frame = new LastFrame(5, 4, 0);
        String oneFrame = frame.toString();
        assertEquals("5|4|", oneFrame);
    }
}