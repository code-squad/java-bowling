package new_ladder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import new_ladder.ladder.Column;

public class ColumnTest {

	@Test
	public void 열_생성() {
		Column column = new Column(5, 5);
		assertEquals(5, column.size());
	}

}
