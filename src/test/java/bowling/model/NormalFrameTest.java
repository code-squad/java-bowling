package bowling.model;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import exception.InvalidPinNumberException;

public class NormalFrameTest {

	NormalFrame frame;
	
	@Before
	public void setup() {
		frame = new NormalFrame();
		frame.play(2);
	}
	
	@Test
	public void 투구1() {
		//play 한 번 돌았기 때문에 tryNo != 1 이라 그 부분을 안 탐
		assertThat(frame.getStatus()).isEqualTo("2");
	}

	@Test
	public void 미스() {
		frame.play(2);
		assertThat(frame.getStatus()).isEqualTo("2|2");
	}
	@Test
	public void 스페어() {
		frame.play(8);
		assertThat(frame.getStatus()).isEqualTo("2|/");
	}
	@Test
	public void 스트라이크() {
		frame = new NormalFrame();
		frame.play(10);
		assertThat(frame.getStatus()).isEqualTo("X");
	}
	@Test
	public void 제로() {
		frame.play(0);
		assertThat(frame.getStatus()).isEqualTo("2|-");
	}
	
	//exception이 나면 pin2가 입력되지 않기 때문에 pin1만 들어있음
	@Test
	public void 익셉션() {
		frame.play(9);
		assertThat(frame.getStatus()).isEqualTo("2");
	}
	
//	AssertJ 안 쓴 거 
/*  @Test(expected = InvalidPinNumberException.class) //exception 나면 true
	public void 익셉션() {
		frame.play(9); //이렇게만 써도 exception 나면 fail 뱉어줌
	}
	//AssertJ 쓴 거
	@Test 
	public void 익셉션() {
		//try-catch로 exception을 잡았기 때문에 여기서 exception을 못 받음.
		assertThatThrownBy(()-> { frame.play(9); }).isInstanceOf(InvalidPinNumberException.class);
		.hasMessageContaining("투구의 합이 10을 초과할 수 없습니다."); 
	}*/
}
