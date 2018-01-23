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

    @Test
    public void Player_toString() throws Exception {
        Player player = new Player("test");

        assertThat(player.toString()).isEqualTo("| " + "NAME" + " |" + "\n" + "| " + "test" + " |");
    }
}