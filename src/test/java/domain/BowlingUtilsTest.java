package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class BowlingUtilsTest {

    @Test
    public void calculateTotalScore() {
        assertThat(BowlingUtils.totalScore(Arrays.asList(Score.of(5), Score.of(3), Score.of(3))), is(11));
    }

}
