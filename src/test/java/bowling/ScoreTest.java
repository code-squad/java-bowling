package bowling;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ScoreTest {
	//생성자 테스트.
	@Test
	public void makeScoreListTest() {
		Score score1 = new Score();
		int initialScore = 0;
		assertEquals(initialScore, score1.getFrameScore());
		assertEquals(0, score1.getAccRec().size());
	}
	//int형 점수를 받은 후, 상태가 업데이트 되었는지 테스트.
	@Test
	public void updateFrameScoreTest1() {
		Score score1 = new Score();
		int firstFrameScore = 10;
		
		score1.updateScore(firstFrameScore, 1);
		
		assertEquals(10, score1.getFrameScore());
		assertEquals(1, score1.getAccRec().size());
	}
	//int형 점수를 두 개 받은 후, 상태가 업데이트 되었는지 테스트.
	@Test
	public void updateFrameScoreTest2() {
		Score score1 = new Score();
		int firstFrameScore = 10;
		int secondFrameScore = 8;
		
		score1.updateScore(firstFrameScore, 1);
		score1.updateScore(secondFrameScore, 1);
		
		assertEquals(8, score1.getFrameScore());
		assertEquals(2, score1.getAccRec().size());
		assertEquals("X", score1.getAccRec().get(0));
		assertEquals("8", score1.getAccRec().get(1));
	}
	//1구와 2구 사이에 " | "가 잘 입력되는지 테스트.
	@Test
	public void checkAccRecTest() {
		Score score1 = new Score();
		int firstFrameScore = 8;
		int secondFrameScore = 2;
		
		score1.updateScore(firstFrameScore, 1);
		score1.checkAccRec();
		score1.updateScore(secondFrameScore, 2);
		
		assertEquals("8 | 2", score1.getAccRec().get(0));
	}

}
