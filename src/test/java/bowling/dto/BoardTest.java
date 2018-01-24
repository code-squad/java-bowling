package bowling.dto;

import bowling.domain.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BoardTest {
    private Board board;

    @Before
    public void init() {
        board = new Board(new CurrentPlayerInfo("KKH", 0), Arrays.asList(
                new PlayerResult("KKH", Arrays.asList("   ", "   ")
                )
        ));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest() {
        new Board(null, null);
    }

    @Test
    public void getCurrentPlayerTest() {
        assertThat(board.getCurrentPlayerInfo()).isEqualTo(new CurrentPlayerInfo("KKH", 0));
    }

    @Test
    public void getPlayerResultsTest() {
        assertThat(board.getPlayerResults()).isEqualTo(Arrays.asList(
                new PlayerResult("KKH", Arrays.asList("   ", "   ")
                )
        ));
    }
}
