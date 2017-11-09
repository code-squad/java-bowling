package new_ladder.ladder;

import java.util.List;

public class Ladder {
	private Column ladder;

	public Ladder(int row, int column) {
		this.ladder = createLadder(row, column);
	}

	private static Column createLadder(int row, int column) {
		return new Column(row, column);
	}

	public int getSize() {
		return ladder.size();
	}

	public List<Row> getLadder() {
		return ladder.getColumn();
	}
}
