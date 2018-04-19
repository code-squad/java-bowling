package domain;

import domain.status.Open;
import domain.status.Spare;
import domain.status.Strike;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ScoresTest {

    Scores testScores;

    @Before
    public void setUp() {
        testScores = Scores.of();
    }

    @Test
    public void assign_Open1() {
        testScores.assignStatus(4);
        assertTrue(testScores.getFrameStatus() instanceof Open);
    }

    @Test
    public void assign_Open2() {
        testScores.assignStatus(2);
        testScores.assignStatus(3);
        assertTrue(testScores.getFrameStatus() instanceof Open);
    }

    @Test
    public void assign_Spare() {
        testScores.assignStatus(2);
        testScores.assignStatus(8);
        assertTrue(testScores.getFrameStatus() instanceof Spare);
    }

    @Test
    public void assign_Strike() {
        testScores.assignStatus(10);
        assertTrue(testScores.getFrameStatus() instanceof Strike);
    }
}
