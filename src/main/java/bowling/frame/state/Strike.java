package bowling.frame.state;

public class Strike extends End {

	@Override
	public String getPresentScore() {
		return "X";
	}

}
