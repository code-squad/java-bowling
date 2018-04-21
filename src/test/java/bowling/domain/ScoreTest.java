package bowling.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreTest {

    @Test
    public void 전체_쓰러뜨린_핀() {
        int numberOfPin = 1;
        Score score = new Score();
        score.sum(new Shot(numberOfPin))
                .sum(new Shot(numberOfPin));

        assertThat(score.totalNumberOfPin())
                .isEqualTo(2);
    }

    @Test
    public void 스트라이크() {
        int numberOfPin = 10;
        Score score = new Score();
        score.sum(new Shot(numberOfPin));

        assertThat(score.status(true))
                .isEqualTo(FrameStatus.STRIKE);
    }

    @Test
    public void 스페어() {
        int numberOfPin = 10;
        Score score = new Score();
        score.sum(new Shot(0))
                .sum(new Shot(numberOfPin));

        assertThat(score.status(false))
                .isEqualTo(FrameStatus.SPARE);
    }

    @Test
    public void 미스() {
        int numberOfPin = 2;
        Score score = new Score();
        score.sum(new Shot(numberOfPin))
                .sum(new Shot(numberOfPin));

        assertThat(score.status(false))
                .isEqualTo(FrameStatus.MISS);
    }

    @Test
    public void 거터() {
        int numberOfPin = 0;
        Score score = new Score();
        score.sum(new Shot(numberOfPin))
                .sum(new Shot(numberOfPin));

        assertThat(score.status(false))
                .isEqualTo(FrameStatus.GUTTER);
    }
}