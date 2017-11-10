package exception;

public class InvalidFrameScoreException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidFrameScoreException(String message) {
		super(message);
	}
}