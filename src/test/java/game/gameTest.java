package game;

import frame.Frame;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class gameTest {
    @Test
    public void 동작테스트() {
        Game game = new Game();
        Frame frame = game.running2(10);
        frame.getFirstPin().getPinFall();
    }
}
