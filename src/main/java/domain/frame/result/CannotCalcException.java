package domain.frame.result;

public class CannotCalcException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CannotCalcException() {
        super();
    }

    public CannotCalcException(String message) {
        super(message);
    }
}
