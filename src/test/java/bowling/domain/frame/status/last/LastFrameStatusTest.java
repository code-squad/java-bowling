package bowling.domain.frame.status.last;

import bowling.domain.frame.status.LastFrameStatus;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LastFrameStatusTest {
    private LastFrameStatus status;

    @Before
    public void setUp() throws Exception {
        status = new LastFrameStatus();
    }

    @Test
    public void isComplete_Only_One_Played() {
        status.bowl(8);
        assertFalse(status.isComplete());
    }

    @Test
    public void isComplete_Two_Played_But_No_Bonus() {
        status.bowl(8);
        status.bowl(1);
        assertTrue(status.isComplete());
    }

    @Test
    public void isComplete_Spare_Bonus_Granted_But_Not_Played_Yet() {
        status.bowl(8);
        status.bowl(2);
        assertFalse(status.isComplete());
    }

    @Test
    public void isComplete_Spare_Bonus_Granted_And_Played() {
        status.bowl(8);
        status.bowl(2);
        status.bowl(10);
        assertTrue(status.isComplete());
    }

    @Test
    public void isComplete_First_Strike_Bonus_Granted_But_Not_Played() {
        status.bowl(10);
        status.bowl(2);
        assertFalse(status.isComplete());
    }

    @Test
    public void isComplete_First_Strike_Bonus_Granted_And_Played() {
        status.bowl(10);
        status.bowl(2);
        status.bowl(9);
        assertTrue(status.isComplete());
    }

    @Test
    public void isComplete_All_Strike_Bonus_Granted_But_Not_Played() {
        status.bowl(10);
        status.bowl(10);
        assertFalse(status.isComplete());
    }

    @Test
    public void isComplete_All_Strike_Bonus_Granted_And_Played() {
        status.bowl(10);
        status.bowl(10);
        status.bowl(9);
        assertTrue(status.isComplete());
    }

    @Test
    public void calculateScore() {
    }

    @Test
    public void toStringTest() {
    }

    @Test
    public void updateScore() {
    }
}