package bowling.util;

import bowling.domain.Pin;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ScoreCalculatorTest {
    @Test
    public void calculateFrameTest() {
        assertThat(ScoreCalculator.calculateFrame(new Pin(3), null)).isEqualTo(null);
        assertThat(ScoreCalculator.calculateFrame(new Pin(3), new Pin(6))).isEqualTo(9);
    }

    @Test
    public void calculateStrikeTest() {
        assertThat(ScoreCalculator.calculateStrike(new Pin(3), new Pin(6))).isEqualTo(19);
    }

    @Test
    public void calculateSpareTest() {
        assertThat(ScoreCalculator.calculateSpare(new Pin(3))).isEqualTo(13);
        assertThat(ScoreCalculator.calculateSpare(null)).isEqualTo(null);
    }

    @Test
    public void calculateDoubleStrikeTest() {
        assertThat(ScoreCalculator.calculateDoubleStrike(20)).isEqualTo(30);
    }
}
