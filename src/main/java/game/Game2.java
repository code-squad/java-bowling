package game;

import frame.Frame2;
import input.Input;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import status.State;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Game2 {
    private List<State> states = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(Game2.class);

    public void match() {
        String name = Input.inputName();
        ResultView.upperBar(states, name, 0);
        for (int i = 1; i < 10; i++) {
            running(i, name);
        }
    }

    public List<State> running(int i, String name) {
        Frame2 frame2 = new Frame2();
        State state = frame2.bowl(Input.inputNum(i));
        states.add(state);
        if (state.isFinish()) {
            ResultView.upperBar(states, name, i);
            return states;
        }
        ResultView.upperBar(states, name, i);
        state = frame2.bowl(Input.inputNum(i));
        states.add(state);
        ResultView.upperBar(states, name, i);
        return states;
    }
}
