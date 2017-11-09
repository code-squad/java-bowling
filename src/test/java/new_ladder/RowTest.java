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
		assertEquals(4, row.getSize());
	}

	@Test
	public void 연속으로_true가_나온다면_하나는_false로() throws Exception {
		Row row = new Row();
		row.addRoute(Route.of(2));
		row.addRoute(Route.of(2));
		row.addRoute(Route.of(2));
		row.addRoute(Route.of(2));
		row.addRoute(Route.of(2));
		row.addRoute(Route.of(2));
		row.addRoute(Route.of(2));
		row.addRoute(Route.of(2));
		row.addRoute(Route.of(2));
		List<Route> temp = row.getLow();
		assertFalse(temp.get(1).getRoute());
		assertFalse(temp.get(3).getRoute());
		assertFalse(temp.get(5).getRoute());
	}

}
