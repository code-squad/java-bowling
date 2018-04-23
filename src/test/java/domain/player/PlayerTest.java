package domain.player;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class PlayerTest {

    @Test(expected = IllegalArgumentException.class)
    public void 이름길이() {
        new Player("abcdef");
    }

    @Test
    public void 이름길이2() {
        new Player("aaa");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 영어아닌이름() {
        new Player("콜린");
    }

    @Test
    public void 영어이름() {
        new Player("pjh");
    }

    @Test
    public void 중복된이름체크() {
        List<Player> players = Arrays.asList(new Player("aaa"), new Player("bbb"), new Player("aaa"));
        assertTrue(Player.isDuplicateName(players));
    }
}
