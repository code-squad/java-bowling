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
        board = new Board(new Player("KKH"), Arrays.asList(
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
        assertThat(board.getCurrentPlayer()).isEqualTo(new Player("KKH"));
    }

    @Test
    public void getPlayerResultsTest() {
        assertThat(board.getPlayerResults()).isEqualTo(Arrays.asList(
                new PlayerResult("KKH", Arrays.asList("   ", "   ")
                )
        ));
    }
}
