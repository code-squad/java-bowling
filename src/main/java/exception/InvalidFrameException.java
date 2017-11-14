package exception;

public class InvalidFrameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidFrameException(String message) {
		super(message);
	}
}