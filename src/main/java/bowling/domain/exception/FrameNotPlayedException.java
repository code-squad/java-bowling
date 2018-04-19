package bowling.domain.exception;

public class FrameNotPlayedException extends RuntimeException {

    public FrameNotPlayedException() {
        super("아직 진행되지 않은 프레임이 있어 점수를 합산할 수 없습니다.");
    }
}