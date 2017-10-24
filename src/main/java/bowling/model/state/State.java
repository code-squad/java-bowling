package bowling.model.state;

public interface State {
	State bowl(int knockedPins);

	boolean isEnd();
	
	String getKnockedPins();

	int getFirstScore();
}
