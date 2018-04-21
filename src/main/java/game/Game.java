package game;

import frame.Frame;
import frame.FrameManager;
import input.Input;
import status.Status;
import view.ResultView;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Frame> frames = new ArrayList<>();
    private List<Status> statuses = new ArrayList<>();
    private List<Result> results = new ArrayList<>();
    public void match() {
        String name = Input.inputName();
        for (int i = 1; i < 10; i++) {
            running(i, name);
        }
    }

//    public List<Frame> running(int i, String name) {
//        FrameManager manager = new FrameManager();
//        Input input = new Input();
//        Frame frame = manager.onFrame(input.inputNum(i));
//        statuses.add(frame.checkStatus());
//        ResultView.upperBar(statuses, name);
//        if (frame.finishFrame()) {
//            frames.add(frame);
//            ResultView.upperBar(statuses, name);
//            return frames;
//        }
//        frame = manager.onFrame(input.inputNum(i));
//        frames.add(frame);
//        statuses.add(frame.checkStatus());
//        ResultView.upperBar(statuses, name);
//        return frames;
//    }

    public List<Frame> running(int i, String name) {
        FrameManager manager = new FrameManager();
        Input input = new Input();
        Frame frame = manager.onFrame(input.inputNum(i));
        Result result = new Result(frame.checkStatus(), frame);
        results.add(result);
        ResultView.upperBar(results, name);
        if (frame.finishFrame()) {
            frames.add(frame);
            ResultView.upperBar(results, name);
            return frames;
        }
        frame = manager.onFrame(input.inputNum(i));
        result = new Result(frame.checkStatus(), frame);
        results.add(result);
        ResultView.upperBar(results, name);
        return frames;
    }

    public List<Frame> getFrames() {
        return frames;
    }
}
