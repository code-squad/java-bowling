package domain;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScoresTest {

    Scores scores;

    @Before
    public void setUp() {
        scores = Scores.of();
    }

    @Test
    public void trysecond_true() {
        scores.add(4);
        scores.add(3);
        assertThat(scores.isTrySecond(), is(true));
    }

    @Test
    public void trysecond_false() {
        scores.add(4);
        assertThat(scores.isTrySecond(), is(false));
    }

    @Test
    public void trythird_true() {
        scores.add(4);
        scores.add(4);
        scores.add(4);
        assertThat(scores.isTryThird(), is(true));
    }

    @Test
    public void tryThird_false() {
        scores.add(4);
        scores.add(4);
        assertThat(scores.isTryThird(), is(false));
    }

    @Test
    public void valid_input_for_last_case_true() {
        scores.add(5);
        scores.add(5);
        assertThat(scores.isValidScoreForLastCase(3), is(true));
    }

    @Test
    public void valid_input_for_last_case_true2() {
        scores.add(5);
        scores.add(5);
        assertThat(scores.isValidScoreForLastCase(10), is(true));
    }

    @Test
    public void valid_input_for_last_case_true3() {
        scores.add(5);
        assertThat(scores.isValidScoreForLastCase(3), is(true));
    }

    @Test
    public void valid_input_for_last_case_false1() {
        scores.add(5);
        assertThat(scores.isValidScoreForLastCase(6), is(false));
    }

}
