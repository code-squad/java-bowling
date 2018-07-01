package bowling.domain;

public class IllegalPlayerNameException extends RuntimeException {
    IllegalPlayerNameException(String message) {
        super(message);
    }
}
