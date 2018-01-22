package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalScoreTest {
    @Test
    public void getType_스트라이크() throws Exception {
        FirstScore firstScore = new FirstScore(10);
        TotalScore totalScore = new TotalScore(firstScore);

        assertThat(totalScore.getType()).isEqualTo(ScoreType.STRIKE);
    }

    @Test
    public void getType_스페어() throws Exception {
        TotalScore totalScore = new TotalScore(7, 3);
        assertThat(totalScore.getType()).isEqualTo(ScoreType.SPARE);
    }

    @Test
    public void getType_미스() throws Exception {
        TotalScore totalScore = new TotalScore(6, 3);

        assertThat(totalScore.getType()).isEqualTo(ScoreType.MISS);
    }

    @Test
    public void toStringTest() throws Exception {
        assertThat(new TotalScore(new FirstScore(10)).toString()).isEqualTo("X");
        assertThat(new TotalScore(9, 1).toString()).isEqualTo("9|/");
        assertThat(new TotalScore(8, 2).toString()).isEqualTo("8|/");
        assertThat(new TotalScore(6, 3).toString()).isEqualTo("6|3");
        assertThat(new TotalScore(6, 0).toString()).isEqualTo("6|-");
        assertThat(new TotalScore(0, 0).toString()).isEqualTo("-|-");
    }

    @Test(expected = IllegalArgumentException.class)
    public void TotalScore_합이10보다큰경우() throws Exception {
        new TotalScore(2, 9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TotalScore_부적합한생성자인자() throws Exception {
        new TotalScore(10, 1);
    }
}