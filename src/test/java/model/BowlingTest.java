package model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Exception.InvalidFrameNumberException;

public class BowlingTest {
	Bowling bowling;
	Pin pin1, pin2, pin3, pin4;

	@Before
	public void setUp() {
		bowling = new Bowling();
		pin1 = new Pin(10);
		pin2 = new Pin(9);
		pin3 = new Pin(1);
		pin4 = new Pin(0);
	}

	@Test
	public void frames_에_제대로_add_가_되는지_확인() {
		for (int i = 0; i < 3; i++) {
			bowling.bowl(pin1);
		}
		assertEquals(4, bowling.getFrames().size());
	}

	@Test
	public void status_담은_리스트가_맞게_반환되는지_확인() throws Exception {
		for (int i = 0; i < 3; i++) {
			bowling.bowl(pin1);
		}
		assertEquals(3, bowling.makeStatus().size());
		assertEquals("X", bowling.makeStatus().get(0));
	}

	@Test
	public void scores_생성_테스트1() throws Exception {
		bowling.bowl(pin1);
		assertEquals(1, bowling.getScores().size());
	}

	@Test
	public void 프레임_개별_score_생성_테스트2() throws Exception {
		bowling.bowl(pin1);
		bowling.bowl(pin2);
		bowling.bowl(pin3);
		assertEquals("20", bowling.getScores().get(0));
		assertEquals(1, bowling.getScores().size());
	}

	@Test
	public void 프레임_개별_score_생성_테스트3() throws Exception {
		for (int i = 0; i < 3; i++) {
			bowling.bowl(pin1);
			bowling.bowl(pin2);
			bowling.bowl(pin3);
		}
		List<String> totalScores = bowling.getTotal();
		assertEquals(5, totalScores.size());
		assertEquals("100", totalScores.get(4));
	}

	@Test
	public void 합친_score_생성_테스트() throws Exception {
		for (int i = 0; i < 2; i++) {
			bowling.bowl(pin1);
			bowling.bowl(pin2);
			bowling.bowl(pin3);
		}
		List<String> totalScores = bowling.getTotal();
		assertEquals(3, totalScores.size());
		assertEquals("60", totalScores.get(2));

	}

	@Test
	public void 합친_score_생성_테스트2() throws Exception {
		try {
			for (int i = 0; i < 9; i++) {
				bowling.bowl(pin1);
			}
		} catch (InvalidFrameNumberException e) {
			List<String> totalScores = bowling.getTotal();
			assertEquals(8, totalScores.size());
			assertEquals("240", totalScores.get(7));
		}
	}

	@Test
	public void 합친_score_생성_테스트3() throws Exception {
		try {
			for (int i = 0; i < 9; i++) {
				bowling.bowl(pin1);
			}
		} catch (InvalidFrameNumberException e) {
			List<String> totalScores = bowling.getTotal();
			assertEquals(8, totalScores.size());
			assertEquals("240", totalScores.get(7));
		}
	}

}
