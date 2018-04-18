package domain;

import org.junit.Before;
import org.junit.Test;
import state.State;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NormalFrameTest {
    private Scanner scanner;

    @Before
    public void setup() {
        scanner = new Scanner(System.in);
    }

    @Test
    public void throwing() {
        Frame frame = new NormalFrame(1);
        frame.throwing(10);
    }

    @Test
    public void isEnd() {
        Frame frame = new NormalFrame(1);
        frame.throwing(5);
        assertFalse(frame.isEnd());
    }

    @Test
    public void spareState() {
        Frame frame = new NormalFrame(1);
        frame.throwing(4);
        frame.throwing(6);
        assertEquals("4|/", frame.printState());
    }

    @Test
    public void firstBowlState() {
        Frame frame = new NormalFrame(1);
        frame.throwing(4);
        assertEquals("4", frame.printState());
    }

    @Test
    public void OpenState() {
        Frame frame = new NormalFrame(1);
        frame.throwing(4);
        frame.throwing(3);
        assertEquals("4|3", frame.printState());
    }

    @Test
    public void strikeState() {
        Frame frame = new NormalFrame(1);
        frame.throwing(10);
        assertEquals("X", frame.printState());
    }
}
