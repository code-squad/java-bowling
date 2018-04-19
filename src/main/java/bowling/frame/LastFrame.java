package bowling.frame;

import bowling.frame.pin.Pins;
import bowling.frame.pin.Score;
import bowling.frame.state.Ready;
import bowling.frame.state.State;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class LastFrame {
    private LinkedList<State> states = new LinkedList<>();

    public LastFrame() {
        states.add(new Ready());
    }

    public LastFrame bowl(int countOfPin) {
        if (isGameEnd()) {
            throw new GameOverException();
        }

        State currentState = states.getLast();
        System.out.println("Current State : " + currentState);

        if (currentState.isFinish()) {
            states.add(new Ready().bowl(Pins.bowl(countOfPin)));
            return this;
        }

        states.removeLast();
        states.add(currentState.bowl(Pins.bowl(countOfPin)));
        return this;
    }

    public boolean isGameEnd() {
        try {
            return isFinish();
        } catch (CannotCalculateException e) {
            return false;
        }
    }

    private boolean isFinish() {
        Score score = getScore();
        return score.canCalculateScore();
    }

    public Score getScore() {
        Score score = getFirstScore();
        for (int i = 1; i < states.size(); i++) {
            State state = states.get(i);
            score = state.calculateAdditionalScore(score);
        }
        System.out.println("Score : " + score);
        return score;
    }

    public Score calculateAdditionalScore(Score beforeScore) {
        Score score = beforeScore;
        for (State state : states) {
            score = state.calculateAdditionalScore(score);
        }
        return score;
    }

    private Score getFirstScore() {
        return states.getFirst().getScore();
    }

    String getDesc() {
        return states.stream()
                .map(State::getDesc)
                .collect(Collectors.joining(" | "));
    }
}
