package exception;

public class InvalidFinFalledException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidFinFalledException(String message) {
		super(message);
	}
}