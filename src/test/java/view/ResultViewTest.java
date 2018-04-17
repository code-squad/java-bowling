package view;

import domain.Frame;
import domain.NormalFrame;
import domain.Pins;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ResultViewTest {
    List<Frame> frames;

    @Before
    public void setup() {
//        frames = Arrays.asList(
//                new NormalFrame(1, new Pins(1), new Pins(9)), new NormalFrame(2, new Pins(1), new Pins(9)),
//                new NormalFrame(3, new Pins(10), new Pins(0)), new NormalFrame(4, new Pins(0), new Pins(10)),
//                new NormalFrame(5, new Pins(1), new Pins(9)), new NormalFrame(6, new Pins(1), new Pins(9)),
//                new NormalFrame(7, new Pins(1), new Pins(9)), new NormalFrame(8, new Pins(1), new Pins(9)),
//                new NormalFrame(9, new Pins(1), new Pins(9)), new NormalFrame(10, new Pins(1), new Pins(9)));
    }

    @Test
    public void printScore() {
        Frame frame1 = new NormalFrame(1, new Pins(10), new Pins(0));
        frame1.updateStatus();
        Frame frame2 = new NormalFrame(2, new Pins(5), new Pins(5));
        frame2.updateStatus();
        List<Frame> frames1 = Arrays.asList(frame1, frame2);
        ResultView.printFrames(frames1);
    }
}
