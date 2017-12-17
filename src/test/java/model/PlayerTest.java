package model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Exception.InvalidFrameNumberException;
import model.Pin;
import model.Player;

public class PlayerTest {
	Player player;
	Pin pin1, pin2, pin3, pin4;

	@Before
	public void setUp() {
		player = new Player("Chloe");
		pin1 = new Pin(10);
		pin2 = new Pin(9);
		pin3 = new Pin(1);
		pin4 = new Pin(0);
	}

	@Test
	public void frames_에_제대로_add_가_되는지_확인() {
		for (int i = 0; i < 3; i++) {
			player.bowl(pin1);
		}
		assertEquals(4, player.getFrames().size());
	}

	@Test
	public void status_담은_리스트가_맞게_반환되는지_확인() throws Exception {
		for (int i = 0; i < 3; i++) {
			player.bowl(pin1);
		}
		assertEquals(3, player.makeStatus().size());
		assertEquals("X", player.makeStatus().get(0));
	}

	@Test
	public void 프레임_개별_score_생성_테스트1() throws Exception {
		player.bowl(pin1);
		assertEquals(0, player.getScores().size());
	}

	@Test
	public void 프레임_개별_score_생성_테스트2() throws Exception {
		player.bowl(pin1);
		player.bowl(pin2);
		player.bowl(pin3);
		assertEquals(20, player.getScores().get(0).getScore());
		assertEquals(1, player.getScores().size());
	}

	@Test
	public void 프레임_개별_score_생성_테스트3() throws Exception {
		for (int i = 0; i < 3; i++) {
			player.bowl(pin1);
			player.bowl(pin2);
			player.bowl(pin3);
		}
		assertEquals(20, player.getScores().get(0).getScore());
		assertEquals(20, player.getScores().get(1).getScore());
		assertEquals(20, player.getScores().get(2).getScore());
		assertEquals(5, player.getScores().size());
	}

	@Test
	public void 합친_score_생성_테스트1() throws Exception {
		for (int i = 0; i < 2; i++) {
			player.bowl(pin1);
			player.bowl(pin2);
			player.bowl(pin3);
		}
		List<String> totalScores = player.getTotal();
		assertEquals(3, totalScores.size());
		assertEquals("60", totalScores.get(2));

	}

	@Test
	public void 합친_score_생성_테스트2() throws Exception {
		try {
			for (int i = 0; i < 9; i++) {
				player.bowl(pin1);
			}
		} catch (InvalidFrameNumberException e) {
			List<String> totalScores = player.getTotal();
			assertEquals(8, totalScores.size());
			assertEquals("240", totalScores.get(7));
		}
	}

	@Test
	public void 열번째프레임일때_isEnd() throws Exception {
		try {
			for (int i = 0; i < 12; i++) {
				player.bowl(pin1);
			}
		} catch (InvalidFrameNumberException e) {
			assertEquals(true, player.isEnd());
		}
	}

	@Test
	public void isLastBowlTest() throws Exception {
		try {
			for (int i = 0; i < 12; i++) {
				player.bowl(pin1);
			}
		} catch (InvalidFrameNumberException e) {
			assertEquals(true, player.isLastBowl());
		}
	}
}
