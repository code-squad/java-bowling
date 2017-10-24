package bowling.exception;

public class BowlingException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BowlingException() {
		super();
	}

	public BowlingException(String message) {
		super(message);
	}
}
