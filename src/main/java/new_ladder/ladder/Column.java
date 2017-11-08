package new_ladder.ladder;

import java.util.ArrayList;
import java.util.List;

public class Column {
	private List<Low> columns;

	public Column(int low, int column) {
		createColumn(low, column);
	}

	private void createColumn(int low, int column) {
		columns = new ArrayList<>();
		for (int i = 0; i < column; i++) {
			columns.add(new Low(low));
		}
	}

	public int size() {
		return columns.size();
	}

	public List<Low> getColumn() {
		return columns;
	}
}
