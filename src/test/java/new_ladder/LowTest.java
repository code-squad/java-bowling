package new_ladder;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import new_ladder.ladder.Low;
import new_ladder.ladder.Route;

public class LowTest {

	@Test
	public void 행_생성() {
		Low low = new Low(5);
		assertEquals(5, low.size());
	}

	@Test
	public void check1_맨_마지막은_무조건_false로() throws Exception {
		Low low = new Low(5);
		List<Route> temp = low.getLow();
		low.checkLow(temp.size() - 1);
		assertFalse(temp.get(4).getRoute());
	}

	@Test
	public void check2_연속으로_true가_나온다면_하나는_false로() throws Exception {
		Low low = new Low(10);
		List<Route> temp = low.getLow();
		int trueCount2 = Low.checkLow(temp);
		assertTrue(trueCount2 <= 5);
	}

}
