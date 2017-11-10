package exception;

public class InvalidPlayerNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidPlayerNameException(String message) {
		super(message);
	}
}