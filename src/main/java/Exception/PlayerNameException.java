package Exception;

public class PlayerNameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PlayerNameException(String message) {
		super(message);
	}
}