package new_ladder.ladder;

import java.util.ArrayList;
import java.util.List;

public class Column {
	private List<Row> columns;

	public Column(int low, int column) {
		createColumn(low, column);
	}

	private void createColumn(int low, int column) {
		columns = new ArrayList<>();
		for (int i = 0; i < column; i++) {
			columns.add(new Row(low));
		}
	}

	public int size() {
		return columns.size();
	}

	public List<Row> getColumn() {
		return columns;
	}
}
