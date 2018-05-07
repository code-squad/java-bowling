package bowling;

import bowling.status.Gutter;
import bowling.status.Miss;
import bowling.status.Ready;
import bowling.status.Running;
import bowling.status.Spare;
import bowling.status.Status;
import bowling.status.Strike;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 * @author sangsik.kim
 */
public class StatusTest {


    @Test
    public void 스트라이크() {
        Status ready = new Ready();

        Status nextStatus = ready.bowl(10);

        assertThat(nextStatus, instanceOf(Strike.class));
    }

    @Test
    public void 스트라이크_점수확인() {
        Status strike = new Strike();

        assertThat(strike.getScore(), is("X"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 스트라이크_한번더_투구() {
        Status strike = new Strike();

        strike.bowl(5);
    }

    @Test
    public void 진행중() {
        Status ready = new Ready();

        Status nextStatus = ready.bowl(5);

        assertThat(nextStatus, instanceOf(Running.class));
    }

    @Test
    public void 진행중_점수확인() {
        Status running = new Running(5);

        assertThat(running.getScore(), is("5"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 진행중_올바르지_않은_핀() {
        Status running = new Running(5);
        running.bowl(7);
    }

    @Test
    public void 미스() {
        Status running = new Running(5);
        Status nextStatus = running.bowl(3);

        assertThat(nextStatus, instanceOf(Miss.class));
    }

    @Test
    public void 미스_점수확인() {
        Status miss = new Miss(5, 3);

        assertThat(miss.getScore(), is("5|3"));
    }

    @Test
    public void 미스_거터포함_점수확인1() {
        Status miss = new Miss(5, 0);

        assertThat(miss.getScore(), is("5|-"));
    }

    @Test
    public void 미스_거터포함_점수확인2() {
        Status miss = new Miss(0, 7);

        assertThat(miss.getScore(), is("-|7"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 미스_올바르지_않은_핀() {
        Status miss = new Miss(5, 7);
    }

    @Test
    public void 스페어() {
        Status running = new Running(5);
        Status nextStatus = running.bowl(5);

        assertThat(nextStatus, instanceOf(Spare.class));
    }

    @Test
    public void 스페어_점수확인() {
        Status spare = new Spare(5, 5);

        assertThat(spare.getScore(), is("5|/"));
    }

    @Test
    public void 스페어_거터포함_점수확인() {
        Status spare = new Spare(0, 5);

        assertThat(spare.getScore(), is("-|/"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 스페어_올바르지_않은_핀() {
        Status spare = new Spare(5, 7);
    }

    @Test
    public void 거터() {
        Status ready = new Ready();
        Status nextStatus = ready.bowl(0);

        assertThat(nextStatus, instanceOf(Gutter.class));
    }

    @Test
    public void 거터_스페어() {
        Status gutter = new Gutter();
        Status nextStatus = gutter.bowl(10);

        assertThat(nextStatus, instanceOf(Spare.class));
    }

    @Test
    public void 거터_미스() {
        Status gutter = new Gutter();
        Status nextStatus = gutter.bowl(5);

        assertThat(nextStatus, instanceOf(Miss.class));
    }

    @Test
    public void 거터_점수확인() {
        Status gutter = new Gutter();

        assertThat(gutter.getScore(), is("-"));
    }
}
