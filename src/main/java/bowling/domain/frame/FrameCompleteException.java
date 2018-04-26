package bowling.domain.frame;

public class FrameCompleteException extends RuntimeException {

    public FrameCompleteException() {
        super("프레임이 끝났습니다.");
    }
}
