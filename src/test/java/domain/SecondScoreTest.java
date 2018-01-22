package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SecondScoreTest {
    @Test
    public void getScoreType() throws Exception {
        assertThat(new SecondScore(7, 3).getScoreType()).isEqualTo(ScoreType.SPARE);
        assertThat(new SecondScore(8, 2).getScoreType()).isEqualTo(ScoreType.SPARE);
        assertThat(new SecondScore(8, 1).getScoreType()).isEqualTo(ScoreType.MISS);
        assertThat(new SecondScore(8, 0).getScoreType()).isEqualTo(ScoreType.GUTTER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void SecondScore_합이10이넘는경우() throws Exception {
        new SecondScore(7, 4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void SecondScore_첫번째스코어가스트라이크인경우() throws Exception {
        new SecondScore(10, 0);
    }
}