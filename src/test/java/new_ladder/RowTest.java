package new_ladder;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import new_ladder.ladder.Row;
import new_ladder.ladder.Route;

public class RowTest {

	@Test
	public void 행_생성() {
		Row row = new Row(5);
		assertEquals(5, row.size());
	}

	@Test
	public void check1_맨_마지막은_무조건_false로() throws Exception {
		Row low = new Row(5);
		List<Route> temp = low.getLow();
		temp = Row.checkLow(temp);
		assertFalse(temp.get(4).getRoute());
	}

	@Test
	public void check2_연속으로_true가_나온다면_하나는_false로() throws Exception {
		Row low = new Row(4);
		List<Route> temp = low.getLow();
		temp = Row.checkLow(temp);
		assertTrue(low.getTrueCount() <= 2);
	}

}
