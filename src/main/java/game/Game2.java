package game;

import frame.FrameManager;
import input.Input;
import status.State;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Game2 {
    private List<State> states = new ArrayList<>();
    public void match() {
        String name = Input.inputName();
        for (int i = 1; i < 10; i++) {
            running(i, name);
        }
    }

    public List<State> running(int i, String name) {
        FrameManager manager = new FrameManager();
        Input input = new Input();
        ResultView.upperBar(states, name, i);
        State state = manager.onFrame(input.inputNum(i));
        states.add(state);
        ResultView.upperBar(states, name, i);
        if (state.isFinish()) {
            states.add(state);
            ResultView.upperBar(states, name, i);
            return states;
        }
        state = manager.onFrame(input.inputNum(i));
        states.add(state);
        ResultView.upperBar(states, name, i);
        return states;
    }
}
