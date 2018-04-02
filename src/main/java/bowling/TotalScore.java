package bowling;

public class TotalScore {
	private int total;
	public static final int MIN = 0;
	public static final int MAX = 300;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		if (MIN > total || MAX < total) {
			throw new IllegalArgumentException("볼링 점수는 최소 0점에서 최대 300점 입니다.");
		}
		this.total = total;
	}
}
