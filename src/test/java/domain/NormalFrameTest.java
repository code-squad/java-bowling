package domain;

import org.junit.Before;
import org.junit.Test;
import state.State;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class NormalFrameTest {
    private Scanner scanner;
    private Frame frame;

    @Before
    public void setup() {
        scanner = new Scanner(System.in);
    }

    @Test
    public void generate() {
        frame = new NormalFrame(1);
    }

    @Test
    public void createScore() {
        frame = new NormalFrame(1);
        Score score = frame.createScore();
    }

    @Test
    public void printScoreAfterEnd() {
        frame = new NormalFrame(1);
        frame.bowl(10);
        frame.createScore();
        assertThat(frame.printScore(), is("10"));
    }

    @Test
    public void bowl() {
        Frame frame = new NormalFrame(1);
        frame.bowl(10);
    }

    @Test
    public void isEnd() {
        Frame frame = new NormalFrame(1);
        frame.bowl(5);
        assertFalse(frame.isEnd());
    }

    @Test
    public void spareState() {
        Frame frame = new NormalFrame(1);
        frame.bowl(4);
        frame.bowl(6);
        assertEquals("4|/", frame.printState());
    }

    @Test
    public void firstBowlState() {
        Frame frame = new NormalFrame(1);
        frame.bowl(4);
        assertEquals("4", frame.printState());
    }

    @Test
    public void OpenState() {
        Frame frame = new NormalFrame(1);
        frame.bowl(4);
        frame.bowl(3);
        assertEquals("4|3", frame.printState());
    }

    @Test
    public void strikeState() {
        Frame frame = new NormalFrame(1);
        frame.bowl(10);
        assertEquals("X", frame.printState());
    }

    @Test
    public void calculateScore() {
        List<Frame> frames = new ArrayList();
        Frame frame = new NormalFrame(1);
        frame.bowl(10); //1
        frames.add(frame);
        frame = frame.next();
        frame.bowl(10); //2
        frame = frame.next();
        frame.bowl(5); //3
        assertEquals(25, frames.get(0).getScore());
    }
}