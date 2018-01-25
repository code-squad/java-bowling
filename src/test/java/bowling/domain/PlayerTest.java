package bowling.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    public void 정상() {
        String name = "KMC";
        assertThat(Player.of(name).getName()).isEqualTo(name);
    }

    @Test
    public void 정상_소문자() {
        String name = "kmc";
        assertThat(Player.of(name).getName()).isEqualTo(name.toUpperCase());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 널체크() {
        Player.of(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 글자수오류() {
        Player.of("k");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 영문이외() {
        Player.of("123");
    }
}