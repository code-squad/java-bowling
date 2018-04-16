package domain;

import org.junit.Before;
import org.junit.Test;
import view.InputView;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NormalFrameTest {
    Scanner scanner;

    @Before
    public void setup() {
        scanner = new Scanner(System.in);
    }

    @Test
    public void throwing() {
        Frame frame = new NormalFrame(1);
        frame.throwing(InputView.getThrowing(scanner));
    }

    @Test
    public void createStatus() {
        Frame frame = new NormalFrame(1);
        frame.throwing(5);
        frame.throwing(5);
        Status status = frame.updateStatus();
        System.out.println(status.toString());
    }

    @Test
    public void notFinished() {
        Frame frame = new NormalFrame(1);
        frame.throwing(1);
        assertFalse(frame.isEnd());
    }
}
