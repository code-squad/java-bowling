//package domain;
//
//import org.junit.Before;
//import org.junit.Test;
//import state.State;
//
//import java.util.Scanner;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.*;
//
//public class NormalFrameTest {
//    private Scanner scanner;
//
//    @Before
//    public void setup() {
//        scanner = new Scanner(System.in);
//    }
//
//    @Test
//    public void generate() {
//        Frame frame = new NormalFrame(1, null);
//    }
//
//    @Test
//    public void createScore() {
//        Frame frame = new NormalFrame(1, null);
//        Score score = frame.createScore();
//    }
//
//    @Test
//    public void printScoreAfterEnd() {
//        Frame frame = new NormalFrame(1, null);
//        frame.throwing(10);
//        frame.createScore();
//        assertThat(frame.printScore(), is("10"));
//    }
//
//    @Test
//    public void throwing() {
//        Frame frame = new NormalFrame(1);
//        frame.throwing(10);
//    }
//
//    @Test
//    public void isEnd() {
//        Frame frame = new NormalFrame(1);
//        frame.throwing(5);
//        assertFalse(frame.isEnd());
//    }
//
//    @Test
//    public void spareState() {
//        Frame frame = new NormalFrame(1);
//        frame.throwing(4);
//        frame.throwing(6);
//        assertEquals("4|/", frame.printState());
//    }
//
//    @Test
//    public void firstBowlState() {
//        Frame frame = new NormalFrame(1);
//        frame.throwing(4);
//        assertEquals("4", frame.printState());
//    }
//
//    @Test
//    public void OpenState() {
//        Frame frame = new NormalFrame(1);
//        frame.throwing(4);
//        frame.throwing(3);
//        assertEquals("4|3", frame.printState());
//    }
//
//    @Test
//    public void strikeState() {
//        Frame frame = new NormalFrame(1);
//        frame.throwing(10);
//        assertEquals("X", frame.printState());
//    }
//}
