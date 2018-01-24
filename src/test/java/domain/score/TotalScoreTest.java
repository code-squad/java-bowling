package domain.score;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalScoreTest {

    @Test
    public void getType_스트라이크() throws Exception {
        TotalScore totalScore = new TotalScore(new Score(10));

        assertThat(totalScore.getType()).isEqualTo(ScoreType.STRIKE);
    }

    @Test
    public void getType_스페어() throws Exception {
        TotalScore totalScore = new TotalScore(new Score(7));
        totalScore.addSecondScore(new Score(3));

        assertThat(totalScore.getType()).isEqualTo(ScoreType.SPARE);
    }

    @Test
    public void getType_미스() throws Exception {
        TotalScore totalScore = new TotalScore(new Score(7));
        totalScore.addSecondScore(new Score(2));

        assertThat(totalScore.getType()).isEqualTo(ScoreType.MISS);
    }

    @Test
    public void getType_UNDEFINED() throws Exception {
        TotalScore totalScore = new TotalScore(new Score(7));
        assertThat(totalScore.getType()).isEqualTo(ScoreType.UNDEFINED);
    }

    @Test(expected = IllegalStateException.class)
    public void addSecondScore_첫번째가스트라이크인경우() throws Exception {
        TotalScore totalScore = new TotalScore(new Score(10));
        totalScore.addSecondScore(new Score(3));
    }

    @Test
    public void toString_스트라이크() throws Exception {
        TotalScore totalScore = new TotalScore(new Score(10));

        assertThat(totalScore.toString()).isEqualTo("X");
    }

    @Test
    public void toString_스페어() throws Exception {
        TotalScore totalScore = new TotalScore(new Score(7));
        totalScore.addSecondScore(new Score(3));

        assertThat(totalScore.toString()).isEqualTo("7|/");
    }

    @Test
    public void toString_미스() throws Exception {
        TotalScore totalScore = new TotalScore(new Score(7));
        totalScore.addSecondScore(new Score(2));

        assertThat(totalScore.toString()).isEqualTo("7|2");
    }
}