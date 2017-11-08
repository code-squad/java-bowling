package new_ladder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import new_ladder.ladder.Route;

public class RouteTest {

	@Test
	public void 초기화() {
		Route route = new Route(1);
		assertEquals(route, new Route(1));
	}

}
