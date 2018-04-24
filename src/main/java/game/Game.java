package game;

import frame.Frame;
import frame.LastFrame;
import input.Input;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import status.Ready;
import status.Spare;
import status.State;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<State> states = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(Game.class);

    public void match() {
        String name = Input.inputName();
        ResultView.upperBar(states, name, 0);
        for (int i = 1; i < 10; i++) {
            running(i, name);
        }
    }

    public List<State> running(int i, String name) {
        Frame frame = new Frame();
        State state = frame.bowl(Input.inputNum(i));
        states.add(state);
        if (state.isFinish()) {
            ResultView.upperBar(states, name, i);
            return states;
        }
        ResultView.upperBar(states, name, i);
        state = frame.bowl(Input.inputNum(i));
        states.add(state);
        ResultView.upperBar(states, name, i);
        return states;
    }

    public List<State> lastRunning(String name) {
        LastFrame lastFrame = new LastFrame();
        states = lastFrame.bowl(Input.inputNum(10));
        if (states.get(0).isStrike()) {
            // 첫번째 스트라이크 출력
            ResultView.upperBar(states, name, 10);
            // 두번째 스트라이크
            states = lastFrame.bowl(Input.inputNum(10));
            ResultView.upperBar(states, name, 10);
            // 세번째 스트라이크
            states = lastFrame.bowl(Input.inputNum(10));
            ResultView.upperBar(states, name, 10);
            return states;
        }
        // FirstBowl 출력
        ResultView.upperBar(states, name, 10);
        states = lastFrame.bowl(Input.inputNum(10));
        if (states.get(1).isSpare()) {
            // 스페어출력
            ResultView.upperBar(states, name, 10);
            // 3번째샷
            states = lastFrame.bowl(Input.inputNum(10));
            ResultView.upperBar(states, name, 10);
            return states;
        }
        // 스페어가 아닌 경우
        ResultView.upperBar(states, name, 10);
        return states;
    }
}
