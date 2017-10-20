package bowling.model;

public interface State {
	State bowl(int knockedPins);
	boolean isEnd();
}
