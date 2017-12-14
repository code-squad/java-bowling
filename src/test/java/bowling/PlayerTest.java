package bowling;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {
	//String을 입력받아 Player 객체를 생성하고, 초기값(이름, 총점수) 테스트.
	@Test
	public void makePlayerTest() {
		Player player1 = new Player("KOO");
		assertEquals("KOO", player1.getName());
		assertEquals(0, player1.getTotalScore());
	}

}
