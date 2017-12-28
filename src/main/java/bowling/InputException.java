package bowling;

@SuppressWarnings("serial")
public class InputException extends RuntimeException{
	public InputException(String msg) {
		super(msg);
	}
}