package bowling.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class PinsTest {

    private Pins pins;

    @Before
    public void setUp() {
        pins = new Pins();
    }

    @Test
    public void 핀을_쓰러뜨릴_수_있다() {
        //when
        pins.knockDown(3);
        pins.knockDown(3);

        //then
        assertThat(pins.getKnockDownPins()).isEqualTo(6);
    }

    @Test
    public void 핀의_최대_갯수만큼만_쓰러뜨릴_수_있다() {
        //given
        int maxPins = Pins.getMaxPins();

        //when
        pins.knockDown(maxPins * 2);

        //then
        assertThat(pins.getKnockDownPins()).isEqualTo(maxPins);
    }

    @Test
    public void 쓰러진_핀_숫자를_문자로_반환() {
        //when
        pins.knockDown(3);

        //then
        assertThat(pins.getSymbol()).isEqualTo("3");
    }

    @Test
    public void 쓰러진_핀_숫자를_구분하여_문자로_반환() {
        //when
        pins.knockDown(3);
        pins.knockDown(3);

        //then
        assertThat(pins.getSymbol()).isEqualTo("3|3");
    }

    @Test
    public void 한번에_쓰러진_핀_10개이면_X_문자_반환() {
        //when
        pins.knockDown(10);

        //then
        assertThat(pins.getSymbol()).isEqualTo("X");
    }

    @Test
    public void 두번에_쓰러진_핀_10개이면_두번째_문자_슬래쉬_반환() {
        //when
        pins.knockDown(1);
        pins.knockDown(9);

        //then
        assertThat(pins.getSymbol()).isEqualTo("1|/");
    }
}