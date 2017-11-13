package bowling.frame.state;

public class Spare extends End {

	private int firstScore;
	private int secondScore;

	public Spare(int firstScore, int secondScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}

	@Override
	public String getPresentScore() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(firstScore);
		stringBuilder.append("|/");
		return stringBuilder.toString();
	}

}
