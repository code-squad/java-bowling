package bowling.frame;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest {
    @Test
    public void bowl_strike() throws Exception {
        Frame frame = new Frame(1);
        Frame next = frame.bowl(10);
        assertEquals(2, next.getNo());
    }

    @Test
    public void bowl_spare() throws Exception {
        Frame frame = new Frame(1);
        Frame next = frame.bowl(8);
        assertEquals(1, next.getNo());
        next = frame.bowl(2);
        assertEquals(2, next.getNo());
    }

    @Test
    public void bowl_miss() throws Exception {
        Frame frame = new Frame(1);
        Frame next = frame.bowl(8);
        assertEquals(1, next.getNo());
        next = frame.bowl(1);
        assertEquals(2, next.getNo());
    }

    @Test
    public void createBoard() throws Exception {
        Frame frame = new Frame(1);
        frame.bowl(8).bowl(2).bowl(9).bowl(1).bowl(10).bowl(5);
        Board board = frame.createBoard();
        System.out.println(board);
    }
}
