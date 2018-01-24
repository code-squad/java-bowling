package domain.score;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ScoreNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void ScoreNumber_음수() throws Exception {
        new ScoreNumber(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ScoreNumber_양수() throws Exception {
        new ScoreNumber(11);
    }

    @Test
    public void add() throws Exception {
        assertThat(new ScoreNumber(5).add(new ScoreNumber(4))).isEqualTo(new ScoreNumber(9));
        assertThat(new ScoreNumber(3).add(new ScoreNumber(4))).isEqualTo(new ScoreNumber(7));
        assertThat(new ScoreNumber(2).add(new ScoreNumber(4))).isEqualTo(new ScoreNumber(6));
        assertThat(new ScoreNumber(6).add(new ScoreNumber(4))).isEqualTo(new ScoreNumber(10));

    }

    @Test(expected = IllegalArgumentException.class)
    public void add_합이10이넘는경우() throws Exception {
        ScoreNumber s1 = new ScoreNumber(5);
        ScoreNumber s2 = new ScoreNumber(6);

        s1.add(s2);
    }
}