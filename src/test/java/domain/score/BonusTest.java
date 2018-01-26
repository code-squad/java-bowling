package domain.score;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class BonusTest {

    @Test
    public void bowl_스페어() throws Exception {
        State state = new Spare(new Pin(7), new Pin(3));
        Bonus bonus = new Bonus(state, new Pin(5));

        assertThat(bonus.getTotalScore().isPresent()).isTrue();
        assertThat(bonus.getTotalScore().get()).isEqualTo(5);
    }

    @Test
    public void bowl_스트라이크() throws Exception {
        State state = new Strike();
        Bonus bonus = new Bonus(state, new Pin(5));
        assertThat(bonus.getTotalScore().isPresent()).isFalse();

        bonus.bowl(new Pin(4));
        assertThat(bonus.getTotalScore().isPresent()).isTrue();
        assertThat(bonus.getTotalScore().get()).isEqualTo(9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bowl_미스인경우에는보너스스코어는없다() throws Exception {
        State state = new Miss(new Pin(7), new Pin(2));
        new Bonus(state, new Pin(5));
    }
}