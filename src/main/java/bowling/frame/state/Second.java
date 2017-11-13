package bowling.frame.state;

public class Second extends End {

	private int firstScore;
	private int secondScore;

	public Second(int firstScore, int secondScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
	}

	@Override
	public String getPresentScore() {
		StringBuilder stringBuilder = new StringBuilder();
		if (secondScore == 0) {
			stringBuilder.append(firstScore);
			stringBuilder.append("|-");
			return stringBuilder.toString();
		}
		stringBuilder.append(firstScore);
		stringBuilder.append("|");
		stringBuilder.append(secondScore);
		return stringBuilder.toString();
	}

}
