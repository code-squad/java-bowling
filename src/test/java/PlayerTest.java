import bowling.domain.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test(expected = IllegalArgumentException.class)
    public void overNameSizeTest() {
        Player player = new Player("river");
    }

    @Test(expected = IllegalArgumentException.class)
    public void underNameSizeTest() {
        Player player = new Player("hi");
    }
}