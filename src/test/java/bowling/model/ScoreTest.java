package bowling.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ScoreTest {
	Score score;
	
	@Test
	public void 핀1(){
		score = new Score(1, 1);
		assertThat(score.getScore()).isEqualTo(-1);
	}
	@Test
	public void 미스(){
		score = new Score(1, 1);
		assertThat(score.addScore(2).getScore()).isEqualTo(3);
	}
	@Test
	public void 스페어(){
		Pins pins = new Pins(2);
		pins.addPin(8);
		score = pins.getScore();
		assertThat(score.addScore(1).getScore()).isEqualTo(11);
	}
	@Test
	public void 스트라이크(){
		score = new Score(10, 2);
		assertThat(score.getScore()).isEqualTo(-1);
	}
	@Test
	public void 스트라이크_핀1() {
		score = new Score(10, 2);
		assertThat(score.addScore(1).getScore()).isEqualTo(-1);
	}
	@Test
	public void 스트라이크_미스() {
		score = new Score(10, 2);
		assertThat(score.addScore(1).addScore(2).getScore()).isEqualTo(13);
	}
	@Test
	public void 스트라이크_스페어() {
		score = new Score(10, 2);
		assertThat(score.addScore(1).addScore(9).getScore()).isEqualTo(20);
	}
	@Test
	public void 투스트라이크() {
		score = new Score(10, 2);
		assertThat(score.addScore(10).addScore(1).getScore()).isEqualTo(21);
	}
	@Test
	public void 쓰리스트라이크() {
		score = new Score(10, 2);
		assertThat(score.addScore(10).addScore(10).getScore()).isEqualTo(30);
	}
}