package domain.status;

public class Strike extends Status {
	@Override
	public String display() {
		return "X";
	}
	
	@Override
	public boolean isClear() {
		return true;
	}
	
	@Override
	public boolean isComplete() {
		return true;
	}
	
	@Override
	public Status next(int pin) {
		throw new RuntimeException("다음 상태를 가질 수 없습니다.");
	}
	
	@Override
	public int getLeftPin() {
		return 0;
	}
}
