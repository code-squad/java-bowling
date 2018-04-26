package bowling.domain.frame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NormalFrameTest {
    private Frame frame;

    @Before
    public void setUp() throws Exception {
        frame = new NormalFrame(1);
    }

    @Test
    public void allBowlsPlayed_Not_Played() {
        assertFalse(frame.allBowlsPlayed());
    }

    @Test
    public void allBowlsPlayed_Played_Once() {
        frame.bowl(9);
        assertFalse(frame.allBowlsPlayed());
    }

    @Test
    public void allBowlsPlayed_One_Strike() {
        frame.bowl(10);
        assertFalse(frame.allBowlsPlayed());
    }

    @Test
    public void allBowlsPlayed_Two_Strikes() {
        frame.bowl(10);
        frame.bowl(10);
        assertFalse(frame.allBowlsPlayed());
    }

    @Test
    public void allBowlsPlayed_Three_Strikes() {
        frame.bowl(10);
        frame.bowl(10);
        frame.bowl(10);
        assertFalse(frame.allBowlsPlayed());
    }

    @Test
    public void allBowlsPlayed_One_Spare() {
        frame.bowl(9);
        frame.bowl(1);
        assertFalse(frame.allBowlsPlayed());
    }

    @Test
    public void isNewFrame_True_Not_Played() {
        assertTrue(frame.isNewFrame());
    }

    @Test
    public void isNewFrame_False_Played_And_Not_Strike() {
        frame.bowl(9);
        assertFalse(frame.isNewFrame());
    }

    @Test
    public void isNewFrame_True_Played_And_Strike() { //new frame is returned as a result
        frame.bowl(10);
        assertTrue(frame.isNewFrame());
    }
}