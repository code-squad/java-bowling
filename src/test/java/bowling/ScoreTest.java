package bowling;

import static org.junit.Assert.*;

import org.junit.Test;

public class ScoreTest {
	//생성자 테스트.
	@Test
	public void makeScoreListTest() {
		Score score1 = new Score();
		int initialScore = 0;
		assertEquals(initialScore, score1.getFrameScore());
		assertEquals(10, score1.getAccRec().size());
	}
	//점수 업데이트 테스트.
	@Test
	public void updateFrameScoreTest() {
		Score score1 = new Score();
		int firstThrow = 9;
		score1.updateFrameScore(firstThrow);
		
		assertEquals(9, score1.getFrameScore());
	}
	//첫 투구가 10점일 때, 띄워지는 점수는 int 10, 점수판 기록은 String "X" 가 되는지 테스트.
	@Test
	public void updateFirstAccRecTest() {
		Score score1 = new Score();
		int firstThrow = 10;
		int frameNum = 0;
		
		score1.updateFrameScore(firstThrow);
		score1.updateFirstAccRec(frameNum);
		
		assertEquals(10, score1.getFrameScore());
		assertEquals("X", score1.getAccRec().get(frameNum));
	}
	//첫 투구가 8점일 때, 띄워지는 점수는 int 8, 점수판 기록은 String "8" 가 되는지 테스트.
	@Test
	public void updateFirstAccRecTest2() {
		Score score1 = new Score();
		int firstThrow = 8;
		int frameNum = 0;
		
		score1.updateFrameScore(firstThrow);
		score1.updateFirstAccRec(frameNum);
		
		assertEquals(8, score1.getFrameScore());
		assertEquals("8", score1.getAccRec().get(frameNum));
	}
	//1구와 2구 사이에 " | " 를 잘 넣어주는지 테스트.
	@Test
	public void readySecondShotTest() {
		Score score1 = new Score();
		int firstThrow = 8;
		int frameNum = 0;
		
		score1.updateFrameScore(firstThrow);
		score1.updateFirstAccRec(frameNum);
		
		score1.readySecondShot(frameNum);
		
		assertEquals("8 | ", score1.getAccRec().get(frameNum));
	}
	//2구를 던졌을 때, 값이 제대로 나오는지 테스트.
	@Test
	public void updateSecondAccRecTest() {
		Score score1 = new Score();
		Frame frame = new Frame();
		
		int firstThrow = 6;
		int secondThrow = 3;
		
		score1.updateFrameScore(firstThrow);
		score1.updateFirstAccRec(frame.getFrameNum());
		
		score1.readySecondShot(frame.getFrameNum());
		
		score1.updateFrameScore(secondThrow);
		score1.updateSecondAccRec(frame);
		
		assertEquals("6 | -", score1.getAccRec().get(frame.getFrameNum()));
	}
	//2구를 던졌을 때, 값이 제대로 나오는지 테스트2.
	@Test
	public void updateSecondAccRecTest2() {
		Score score1 = new Score();
		Frame frame = new Frame();
		
		int firstThrow = 6;
		int secondThrow = 4;
		
		score1.updateFrameScore(firstThrow);
		frame.updatePin(firstThrow);
		score1.updateFirstAccRec(frame.getFrameNum());
		
		score1.readySecondShot(frame.getFrameNum());
		
		score1.updateFrameScore(secondThrow);
		frame.updatePin(secondThrow);
		score1.updateSecondAccRec(frame);
		assertEquals("6 | /", score1.getAccRec().get(frame.getFrameNum()));
	}
//	//1구 2구 전체를 계산하여 결과를 출력해주는 메소드 테스트.
//	@Test
//	public void updateScoreTest() {
//		Score score1 = new Score();
//		Frame frame = new Frame();
//		
//		int firstThrow = 10;
//		
//		score1.updateScore(firstThrow, frame);
//		
//		assertEquals(10, score1.getFrameScore());
//		assertEquals("X", score1.getAccRec().get(frame.getFrameNum()));
//	}
//	//1구 2구 전체를 계산하여 결과를 출력해주는 메소드 테스트2.
//	@Test
//	public void updateScoreTest2() {
//		Score score1 = new Score();
//		Frame frame = new Frame();
//		
//		int firstThrow = 6;
//		int secondThrow = 4;
//		
//		score1.updateScore(firstThrow, frame);
//		score1.updateScore(secondThrow, frame);
//		
//		assertEquals(4, score1.getFrameScore());
//		assertEquals("6 | /", score1.getAccRec().get(frame.getFrameNum()));
//	}

}
