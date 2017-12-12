package bowling.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import bowling.model.state.NormalPins;

public class PinsTest {
	NormalPins pins; 
	
	@Before
	public void setUp() {
		pins = new NormalPins(4);
	}
	
	@Test
	public void 핀1() {
		assertThat(pins.getScore()).isEqualTo(new Score(4, 1));
	}
	@Test
	public void 미스() {
		pins.addPin(3);
		assertThat(pins.getScore()).isEqualTo(new Score(7, 0));
	}
	
	@Test
	public void 스페어() {
		pins.addPin(6);
		assertThat(pins.getScore()).isEqualTo(new Score(10, 1));
	}
	
	@Test
	public void 스페어_합계() {
		pins.addPin(6);
		NormalPins pins2 = new NormalPins(1);
		assertThat(pins2.calculate(pins.getScore())).isEqualTo(new Score(11, 0));
	}
	@Test
	public void 스트라이크() {
		pins = new NormalPins(10);
		assertThat(pins.getScore()).isEqualTo(new Score(10, 2));
	}
	@Test
	public void 투스트라이크() {
		Score score = new Score(10, 2);
		pins = new NormalPins(10);
		assertThat(pins.calculate(score)).isEqualTo(new Score(20, 1));
	}
	@Test
	public void 투스트라이크_합계() {
		Score score = new Score(10, 2);
		pins = new NormalPins(10);
		NormalPins pins2 = new NormalPins(2);
		assertThat(pins2.calculate(pins.calculate(score))).isEqualTo(new Score(22, 0));
	}
	@Test
	public void 쓰리스트라이크_합계() {
		Score score = new Score(10, 2);
		pins = new NormalPins(10);
		NormalPins pins2 = new NormalPins(10);
		assertThat(pins2.calculate(pins.calculate(score))).isEqualTo(new Score(30, 0));
	}

}