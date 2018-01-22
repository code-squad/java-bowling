package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FirstScoreTest {

    @Test
    public void isStrike() throws Exception {
        FirstScore firstScore = new FirstScore(10);
        assertThat(firstScore.isStrike()).isTrue();
    }

    @Test
    public void isFalse() throws Exception {
        FirstScore firstScore = new FirstScore(3);
        assertThat(firstScore.isStrike()).isFalse();
    }
}