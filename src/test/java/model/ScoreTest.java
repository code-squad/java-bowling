package model;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ScoreTest {
    @Test(expected = IllegalArgumentException.class)
    public void checkValidInputTest() {
        Score score = new Score();

        Ball firstBall = new Ball(2);
        Ball secondBall = new Ball(9);

        score.add(firstBall);
        score.add(secondBall);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkInvalidInputTestForFinal() {
        Score score = new Score();

        Ball firstBall = new Ball(10);
        Ball secondBall = new Ball(9);
        Ball thirdBall = new Ball(3);

        score.add(firstBall);
        score.add(secondBall);
        score.add(thirdBall);
    }

    @Test
    public void checkValidInputTestForFinal() {
        Score score = new Score();

        Ball firstBall = new Ball(10);
        Ball secondBall = new Ball(5);
        Ball thirdBall = new Ball(3);

        score.add(firstBall);
        score.add(secondBall);
        score.add(thirdBall);

        assertThat(score.getScoreSum()).isEqualTo(18);
    }
}