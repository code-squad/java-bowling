package bowling;

@SuppressWarnings("serial")
public class InputException extends Exception{
	public InputException(String msg) {
		super(msg);
		System.out.println(msg);
	}
}