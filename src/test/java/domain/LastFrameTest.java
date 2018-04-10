package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class LastFrameTest {
    private Frame frame;

    @Test
    public void toStringTest_Strike() {
        frame = new LastFrame();
        frame.updateFrame(10);
        frame.updateFrame(10);
        String oneFrame = frame.toString();
        assertEquals("X| |X", oneFrame);
    }

    @Test
    public void toStringTest_Spare() {
        frame = new LastFrame();
        frame.updateFrame(8);
        frame.updateFrame(2);
        frame.updateFrame(8);
        String oneFrame = frame.toString();
        assertEquals("8|/|8", oneFrame);
    }

    @Test
    public void toStringTest_Normal() {
        frame = new LastFrame();
        frame.updateFrame(5);
        frame.updateFrame(4);
        String oneFrame = frame.toString();
        assertEquals("5|4|", oneFrame);
    }
}