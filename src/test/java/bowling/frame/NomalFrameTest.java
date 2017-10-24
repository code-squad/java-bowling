package bowling.frame;

import static org.junit.Assert.*;

import org.junit.Test;

import bowling.exception.BowlingException;
import bowling.frame.state.First;
import bowling.frame.state.Second;
import bowling.frame.state.Spare;
import bowling.frame.state.Strike;

public class NomalFrameTest {

	@Test(expected = BowlingException.class)
	public void 스트라이크_상태에서_추가입력_발생시() throws Exception {
		Frame frame = new NomalFrame();
		frame.bowl(10);
		frame.bowl(1);
	}

	@Test
	public void 스트라이크_체크() throws Exception {
		Frame frame = new NomalFrame();
		frame.bowl(10);
		assertTrue(frame.getState() instanceof Strike);
		System.out.println(frame.getState().getChar());
	}

	@Test
	public void bowl_spare() throws Exception {
		Frame frame = new NomalFrame();
		frame.bowl(8);
		frame.bowl(2);
		assertTrue(frame.getState() instanceof Spare);
		System.out.println(frame.getState().getChar());
	}

	@Test
	public void bowl_First() throws Exception {
		Frame frame = new NomalFrame();
		frame.bowl(5);
		assertTrue(frame.getState() instanceof First);
		System.out.println(frame.getState().getChar());
	}

	@Test
	public void bowl_second() throws Exception {
		Frame frame = new NomalFrame();
		frame.bowl(5);
		frame.bowl(2);
		assertTrue(frame.getState() instanceof Second);
		System.out.println(frame.getState().getChar());
	}

	@Test
	public void 프레임_점수_계산() throws Exception {
		Frame frame = new NomalFrame();
		frame.bowl(3);
		System.out.println(frame.getState());
		System.out.println(frame.getFirstScore());
		System.out.println(frame.getSecondScore());
		frame.bowl(4);
		System.out.println(frame.getState());
		System.out.println(frame.getFirstScore());
		System.out.println(frame.getSecondScore());
		assertEquals(7, frame.getEndScore());
	}

}
