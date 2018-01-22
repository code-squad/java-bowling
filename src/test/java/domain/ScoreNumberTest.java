package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreNumberTest {

    @Test
    public void sum() throws Exception {
        ScoreNumber o1 = new ScoreNumber(1);
        ScoreNumber o2 = new ScoreNumber(2);

        assertThat(o1.sum(o2)).isEqualTo(new ScoreNumber(3));
    }

    @Test
    public void equals() throws Exception {
        ScoreNumber o1 = new ScoreNumber(1);

        assertThat(o1.equals(new ScoreNumber(1))).isTrue();
        assertThat(o1.equals(new ScoreNumber(2))).isFalse();
    }

}