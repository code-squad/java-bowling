
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class playerTest {
	
	@Test
	public void playTestWhenNormalValue() {
		Player player = new Player("PJS");
		int pinsPerTry = 3;
		player.play(pinsPerTry);
		assertEquals(0, player.getFrameNum());
	}
	
	@Test
	public void playTestWhenValue10() {
		Player player = new Player("PJS");
		int pinsPerTry = 10;
		player.play(pinsPerTry);
		assertEquals(1, player.getFrameNum());
	}
	
	@Test
	public void playTestWhenValuesOfNum2() {
		Player player = new Player("PJS");
		int pinsPerTry = 3;
		player.play(pinsPerTry);
		player.play(pinsPerTry);
		assertEquals(1, player.getFrameNum());
	}
}
