package bowling.frame;

public interface State {
	State bowl(int countOfPin);
	
	boolean isEnd();
}
