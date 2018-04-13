package view;

import domain.NormalFrame;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ResultViewTest {
    List<NormalFrame> frames;

    @Before
    public void setup() {
        frames = Arrays.asList(
                new NormalFrame(1, 9), new NormalFrame(2, 8),
                new NormalFrame(10, 0), new NormalFrame(0, 10),
                new NormalFrame(1, 8), new NormalFrame(0, 0),
                new NormalFrame(1, 0), new NormalFrame(0, 1),
                new NormalFrame(10, 0), new NormalFrame(10, 0));
    }

    @Test
    public void printScore() {
        Resultview.printResult("htw", frames);
    }
}
