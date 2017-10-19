package jjak.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	Player player;
	List<Frame> frames = new ArrayList<>();

	@Before
	public void setup() {
		
	}

	@Test
	public void 이름() {
		player = new Player("name");
		assertEquals("name", player.getName());
	}
	
	@Test
	public void 점수입력_받자() {
		player.setScore(2);
		assertEquals(2,player.frames.get(0).state.getFirstScore());
		player.setScore(4);
		assertEquals(4,player.frames.get(0).state.getSeconScore());
	}

}
