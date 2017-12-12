package bowling.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bowling.model.state.TenFramePins;

public class TenFramePinsTest {
	TenFramePins tenPins;
	
	@Before
	public void setup() {
		tenPins = new TenFramePins(2);
	}
	@Test
	public void 프레임_진행() {
		assertThat(tenPins.isEnd()).isEqualTo(false);
	}
	@Test
	public void 프레임_끝_미스() {
		tenPins.addPin(3);
		assertThat(tenPins.isEnd()).isEqualTo(true);
	}
	@Test
	public void 프레임_진행_스페어() {
		tenPins.addPin(8);
		assertThat(tenPins.isEnd()).isEqualTo(false);
	}
	@Test
	public void 프레임_끝_스페어() {
		tenPins.addPin(8);
		tenPins.addPin(3);
		assertThat(tenPins.isEnd()).isEqualTo(true);
	}
	@Test
	public void 프레임_진행_스트라이크() {
		tenPins = new TenFramePins(10);
		assertThat(tenPins.isEnd()).isEqualTo(false);
	}
	@Test
	public void 프레임_진행_스트라이크_핀2() {
		tenPins = new TenFramePins(10);
		tenPins.addPin(5);
		assertThat(tenPins.isEnd()).isEqualTo(false);
	}
	@Test
	public void 프레임_끝_스트라이크() {
		tenPins = new TenFramePins(5);
		tenPins = new TenFramePins(4);
		assertThat(tenPins.isEnd()).isEqualTo(false);
	}

}
