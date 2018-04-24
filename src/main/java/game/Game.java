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
        lastRunning(name);
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
        LastFrame lastFrame = new LastFrame(getStates());
        states = lastFrame.bowl(Input.inputNum(10));
        if (states.get(0).isStrike()) {
            ResultView.upperBar(states, name, 10);
            states = lastFrame.bowl(Input.inputNum(10));
            ResultView.upperBar(states, name, 10);
            states = lastFrame.bowl(Input.inputNum(10));
            ResultView.upperBar(states, name, 10);
            return states;
        }

        ResultView.upperBar(states, name, 10);
        states = lastFrame.bowl(Input.inputNum(10));
        if (states.get(1).isSpare()) {
            ResultView.upperBar(states, name, 10);
            states = lastFrame.bowl(Input.inputNum(10));
            ResultView.upperBar(states, name, 10);
            return states;
        }

        ResultView.upperBar(states, name, 10);
        return states;
    }

    public List<State> getStates() {
        return states;
    }
}
