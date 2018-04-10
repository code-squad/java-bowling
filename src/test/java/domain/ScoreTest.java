package domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScoreTest {

    Score score;

    @Test(expected = IllegalArgumentException.class)
    public void initializa_exception() {
        score = Score.of(11);
    }

    @Test
    public void isTen_true() {
        score = Score.of(10);
        assertThat(score.isTen(), is(true));
    }

    @Test
    public void isTen_false() {
        score = Score.of(9);
        assertThat(score.isTen(), is(false));
    }

    @Test
    public void isUnderTen_true() {
        score = Score.of(9);
        assertThat(score.isUnderTen(), is(true));
    }

    @Test
    public void isUnderTen_false() {
        score = Score.of(5);
        score.sum(Score.of(5));
        assertThat(score.isUnderTen(), is(false));
    }

    @Test
    public void isUnderTwenty_true() {
        score = Score.of(10);
        score.sum(Score.of(10));
        assertThat(score.isUnderTwenty(), is(true));
    }

    @Test
    public void isUnderTwenty_false() {
        score = Score.of(5);
        score.sum(Score.of(10));
        score.sum(Score.of(6));
        assertThat(score.isUnderTwenty(), is(false));
    }

    @Test
    public void summationTest() {
        score = Score.of(2);
        score.sum(Score.of(3));
        assertThat(score.getScore(), is(5));
    }


}
