package domain.score;

public class Miss implements State {

    @Override
    public State bowl(int countOfPin) {
        throw new IllegalStateException();
    }
}
