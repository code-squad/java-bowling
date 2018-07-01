package bowling.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import org.junit.Before;
import org.junit.Test;

public class FrameTest {

    private Frame frame;

    @Before
    public void setUp() {
        frame = new Frame();
    }

    @Test
    public void miss_frame() {
        //given
        int firstBowl = 4;
        int secondBowl = 3;

        //when
        frame.roll(firstBowl);
        frame.roll(secondBowl);

        //then
        assertThat(frame.getScore()).isEqualTo(firstBowl + secondBowl);
    }

    @Test
    public void strike_후_추가_투구_할_수_없음() {
        //given
        int strike = 10;
        frame.roll(strike);

        //when then
        assertThat(frame.canRoll()).isFalse();
    }

    @Test
    public void 한_프레임은_최대_두번_투구_가능() {
        //given
        frame.roll(0);
        frame.roll(0);

        //when then
        assertThat(frame.canRoll()).isFalse();
    }

    @Test(expected = MaximumRollExceededException.class)
    public void strike_를_한_후_추가_투구를_시도하면_예외발생() {
        //given
        int strike = 10;
        frame.roll(strike);

        //when
        frame.roll(1);

        //then
        fail("스트라이크를 한 프레임은 더 투구할 수 없어야 한다");
    }
}