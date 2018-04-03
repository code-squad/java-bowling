package bowling;

public class EndGameException extends RuntimeException {
	@Override
	public String getMessage() {
		return "볼링 게임이 끝났습니다.";
	}
}
