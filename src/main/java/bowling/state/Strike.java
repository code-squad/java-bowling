package bowling.state;

public class Strike extends End {
	@Override
	public String toString() {
		return "strike";
	}

	@Override
	public int getScore() {
		return 10;
	}
}
