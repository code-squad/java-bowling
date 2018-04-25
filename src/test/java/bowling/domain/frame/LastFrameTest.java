package bowling.domain.frame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LastFrameTest {
    private Frame frame;

    @Before
    public void setUp() throws Exception {
        frame = new LastFrame();
    }

    @Test
    public void isComplete_Bonus_Not_Played() {
        frame.bowl(10);
        frame.bowl(10);
        assertFalse(frame.isNewFrame());
    }

    @Test
    public void isComplete_Bonus_Played() {
        frame.bowl(10);
        frame.bowl(10);
        frame.bowl(10);
        assertTrue(frame.isNewFrame());
    }

    @Test
    public void isComplete_Bonus_Not_Given() {
        frame.bowl(8);
        frame.bowl(1);
        assertTrue(frame.isNewFrame());
    }

    @Test
    public void isNewFrame_True_Not_Played() {
        assertTrue(frame.isNewFrame());
    }

    @Test
    public void isNewFrame_Played_And_Not_Complete1() {
        frame.bowl(10);
        assertFalse(frame.isNewFrame());
    }

    @Test
    public void isNewFrame_Played_And_Not_Complete2() {
        frame.bowl(10);
        frame.bowl(10);
        assertFalse(frame.isNewFrame());
    }

    @Test
    public void isNewFrame_Played_And_Not_Complete3() {
        frame.bowl(9);
        frame.bowl(1);
        assertFalse(frame.isNewFrame());
    }

    @Test
    public void isNewFrame_True_Played_Complete_Without_Bonus() {
        frame.bowl(8);
        frame.bowl(1);
        assertTrue(frame.isNewFrame());
    }

    @Test
    public void isNewFrame_True_Played_Complete_With_Strike_Bonus() {
        frame.bowl(10);
        frame.bowl(10);
        frame.bowl(10);
        assertTrue(frame.isNewFrame());
    }

    @Test
    public void isNewFrame_True_Played_Complete_With_Spare_Bonus() {
        frame.bowl(9);
        frame.bowl(1);
        frame.bowl(9);
        assertTrue(frame.isNewFrame());
    }
}