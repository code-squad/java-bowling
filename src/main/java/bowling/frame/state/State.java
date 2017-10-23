package bowling.frame.state;

public interface State {
	State bowl(int countOfPin);
	
	boolean isFinish();
}
