package bowling;

public class CannotCalculateException extends RuntimeException {
	@Override
	public String getMessage() {
		return "계산을 할 수가 없습니다.";
	}
}
