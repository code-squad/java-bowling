package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test(expected = IllegalArgumentException.class)
    public void Player_빈문자열() throws Exception {
        new Player("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void Player_널() throws Exception {
        new Player(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void Player_3글자이상() throws Exception {
        new Player("test");
    }

    @Test
    public void Player_toString() throws Exception {
        Player player = new Player("KKJ");

        assertThat(player.toString()).isEqualTo("| " + "KKJ" + "  |");
    }
}