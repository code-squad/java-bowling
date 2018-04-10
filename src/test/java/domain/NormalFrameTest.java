package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class NormalFrameTest {
    private NormalFrame frame;

    @Test
    public void toStringTest_Strike() {
        frame = new NormalFrame();
        frame.updateFrame(10);
        String oneFrame = frame.toString();
        assertEquals("X", oneFrame);
    }

    @Test
    public void toStringTest_Spare() {
        frame = new NormalFrame();
        frame.updateFrame(8);
        frame.updateFrame(2);
        String oneFrame = frame.toString();
        assertEquals("8|/", oneFrame);
    }

    @Test
    public void toStringTest_Normal() {
        frame = new NormalFrame();
        frame.updateFrame(5);
        frame.updateFrame(4);
        String oneFrame = frame.toString();
        assertEquals("5|4", oneFrame);
    }
}