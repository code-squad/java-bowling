package bowling.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DownPinCountTest {

    @Test
    public void 숫자로생성() {
        assertThat(DownPinCount.of(10).getCount()).isEqualTo(10);
        assertThat(DownPinCount.of(0).getCount()).isEqualTo(0);
    }

    @Test
    public void 문자열로생성() {
        assertThat(DownPinCount.of("10").getCount()).isEqualTo(10);
        assertThat(DownPinCount.of("0").getCount()).isEqualTo(0);
    }

    @Test
    public void 문자열로생성_앞뒤공백포함() {
        assertThat(DownPinCount.of(" 10 ").getCount()).isEqualTo(10);
        assertThat(DownPinCount.of(" 0 ").getCount()).isEqualTo(0);
    }

    @Test
    public void add() {
        DownPinCount zero = DownPinCount.of(0).add(DownPinCount.of(0));
        DownPinCount ten = DownPinCount.of(5).add(DownPinCount.of(5));

        assertThat(zero.getCount()).isEqualTo(0);
        assertThat(ten.getCount()).isEqualTo(10);
    }

    @Test
    public void 스트라이크() {
        DownPinCount ten = DownPinCount.of(10);
        assertThat(DownPinCount.STRIKE).isEqualTo(ten);
        assertThat(ten.isStrike()).isTrue();
    }

    @Test
    public void 스페어() {
        DownPinCount eight = DownPinCount.of(8);
        DownPinCount two = DownPinCount.of(2);
        DownPinCount zero = DownPinCount.of(0);
        assertThat(eight.isSpare(two)).isTrue();
        assertThat(eight.isSpare(zero)).isFalse();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 범위를_벗어난_숫자() {
        DownPinCount.of(11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자가_아닌문자() {
        DownPinCount.of("abc");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 합쳤을때_10이상() {
        DownPinCount.of(5).isSpare(DownPinCount.of(6));
    }

}