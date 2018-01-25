package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NormalFrameTest {
    private NormalFrame normalFrame;

    @Before
    public void init() {
        FinalFrame finalFrame = new FinalFrame();
        finalFrame.rollBowlingBall(new Pin(5));
        finalFrame.rollBowlingBall(new Pin(5));

        normalFrame = new NormalFrame(finalFrame);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest() {
        new NormalFrame(null);
    }

    @Test
    public void calculateSpareTest() {
        normalFrame.rollBowlingBall(new Pin(4));
        assertThat(normalFrame.calculateSpare()).isEqualTo(14);
    }

    @Test
    public void calculateStrikeTest() {
        normalFrame.rollBowlingBall(new Pin(10));
        assertThat(normalFrame.calculateStrike()).isEqualTo(25);
    }

    @Test
    public void calculateStrikeTest2() {
        normalFrame.rollBowlingBall(new Pin(5));
        assertThat(normalFrame.calculateStrike()).isEqualTo(null);

        normalFrame.rollBowlingBall(new Pin(5));
        assertThat(normalFrame.calculateStrike()).isEqualTo(20);
    }

    @Test
    public void getFrameScore() {
        assertThat(normalFrame.getFrameScore()).isEqualTo(null);
        normalFrame.rollBowlingBall(new Pin(5));
        normalFrame.rollBowlingBall(new Pin(3));
        assertThat(normalFrame.getFrameScore()).isEqualTo(8);
    }
}
