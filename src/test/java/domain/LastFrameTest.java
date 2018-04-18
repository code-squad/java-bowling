package domain;

import org.junit.Test;
import org.omg.SendingContext.RunTime;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LastFrameTest {
    @Test
    public void throwing() {
        List<Frame> frames = new ArrayList<>();
        for (int index = 0; index < 9; index++) {
            Frame frame = new NormalFrame(index+1);
            frames.add(frame);
        }
        Frame frame = new LastFrame(10);
        frame.throwing(1);
        frame.throwing(8);
//        frame.throwing(10);
//        if (frame.isEnd()) {
//            throw new RuntimeException("종료 조건 발동");
//        }
        frames.add(frame);
        ResultView.printFrames(frames, "HTW");
    }
}
