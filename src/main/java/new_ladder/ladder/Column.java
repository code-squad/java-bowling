package new_ladder.ladder;

import java.util.ArrayList;
import java.util.List;

public class Column {
	private List<Row> columns;

	public Column(int row, int column) {
		createColumn(row, column);
	}

	private void createColumn(int row, int column) {
		columns = new ArrayList<>();
		for (int i = 0; i < column; i++) {
			columns.add(new Row(row));
		}
	}

	public int size() {
		return columns.size();
	}

	public List<Row> getColumn() {
		return columns;
	}
}
