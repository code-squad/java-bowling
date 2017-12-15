package bowling;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrameTest {
	//생성자 테스트.
	@Test
	public void startFrameTest() {
		Frame frame = new Frame();
		
		assertEquals(0, frame.getFrameNum());
		assertEquals(10, frame.getPinNum());
		assertEquals(1, frame.getTryNum());
	}
	//frame이 잘 넘어가는지 테스트.
	@Test
	public void goNextFrameTest() {
		Frame frame = new Frame();
		
		frame.goNextFrame();
		assertEquals(1, frame.getFrameNum());
		assertEquals(1, frame.getTryNum());
		assertEquals(10, frame.getPinNum());
	}
	//시도 횟수(투구 횟수) 1 증가시키는 메소드 테스트.
	@Test
	public void addTryNumTest() {
		Frame frame = new Frame();
		
		frame.addTryNum();
		assertEquals(2, frame.getTryNum());
	}
	//시도 횟수(투구 횟수) 다시 초기값(1)으로 변경해주는 메소드 테스트.
	@Test
	public void clearTryNumTest() {
		Frame frame = new Frame();
		
		frame.addTryNum();
		frame.clearTryNum();
		assertEquals(1, frame.getTryNum());
	}
	//score만큼 핀을 넘어뜨리고, 남은 핀 갯수를 세는 메소드 테스트.
	@Test
	public void updatePinTest() {
		Frame frame = new Frame();
		int score = 8;
		frame.updatePin(score);
		
		assertEquals(2, frame.getPinNum());
	}
	//int 형의 pinNum을 10으로 초기화하는 메소드 테스트.
	@Test
	public void clearPinTest() {
		Frame frame = new Frame();
		frame.clearPin();
		
		assertEquals(10, frame.getPinNum());
	}
}
