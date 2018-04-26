package domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FramesTest {
    private Frames frames;

    @Before
    public void setUp() {
        frames = new Frames();
    }

    @Test
    public void createFirstFrame() {
        Frame frame = frames.createFirstFrame();
    }

    @Test
    public void isEmpty() {
        frames.isEmpty();
    }

    @Test
    public void add() {
        Frame frame = frames.createFirstFrame();
        frames.add(frame);
    }

    @Test
    public void equalsFrameCount() {
        Frame frame = frames.createFirstFrame();
        frames.add(frame);
        assertEquals(true, frames.equalsFrameCount(1));
    }

    @Test
    public void printFramesState() {
        Frame frame = new NormalFrame(1);
        frame.bowl(new Pins(3));
        frame.bowl(new Pins(7));
        frames.add(frame);
        assertThat(frames.printFramesState(0), is("3|/"));
    }

    @Test
    public void printFramesScore() {
        Frame frame1 = new NormalFrame(1);
        frame1.bowl(new Pins(3));
        frame1.bowl(new Pins(7));
        frames.add(frame1);

        Frame frame2 = frame1.next();
        frame2.bowl(new Pins(10));
        frames.add(frame2);

        assertThat(frames.printFramesScore(0, 0), is(20));
    }
}
