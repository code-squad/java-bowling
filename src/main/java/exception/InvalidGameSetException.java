package exception;

public class InvalidGameSetException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidGameSetException(String message) {
		super(message);
	}
}