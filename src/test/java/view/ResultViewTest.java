package view;

import domain.Frame;
import domain.LastFrame;
import domain.NormalFrame;
import domain.Pins;
import org.junit.Before;
import org.junit.Test;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultViewTest {
    List<Frame> frames = new ArrayList<>();

    @Before
    public void setup() {
    }

    @Test
    public void printScore() {
        Frame frame = new NormalFrame(1);
        frame.throwing(5);
        frame.throwing(5);
        frames.add(frame);
        ResultView.printFrames(frames, "HTW");
    }

    @Test
    public void lastFrame() {
        for (int index = 0; index < 9; index++) {
            Frame frame = new NormalFrame(index+1);
            frames.add(frame);
        }
        Frame frame = new LastFrame(10);
        frame.throwing(1);
        frame.throwing(9);
        frames.add(frame);
        ResultView.printFrames(frames, "HTW");
    }
}
