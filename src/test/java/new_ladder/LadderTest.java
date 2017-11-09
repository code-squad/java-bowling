package new_ladder;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import new_ladder.ladder.Ladder;
import new_ladder.ladder.Route;
import new_ladder.ladder.Row;

public class LadderTest {

	@Test
	public void 사다리초기화() {
		Ladder ladder = new Ladder(5, 5);
		assertEquals(5, ladder.getSize());
	}

	@Test
	public void 사다리_출력하기() throws Exception {
		Ladder ladder = new Ladder(5, 5);
		List<Row> temp = ladder.getLadder();
		for (Row low : temp) {
			for (Route route : low.getLow()) {
				System.out.print("|");
				if (route.getRoute()) {
					System.out.print(route);
				} else {
					System.out.print("     ");
				}
			}
			System.out.println();
		}
	}

}
