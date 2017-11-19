package bowling;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

	BowlingGame bg;
	@Before
	public void setup() {
		bg = new BowlingGame();
	}
	
	@Test
	public void 텐프레임_X() {
		assertThat(bg.tenFrame(10)).contains("X");
	}
	
	@Test
	public void 텐프레임_XX() {
		bg.ballNum = 2;
		List<String> marks = new ArrayList<>();
		marks.add("X");
		List<Integer> pins = new ArrayList<>();
		pins.add(10);
		pins.add(0);
		bg.setMarks(marks);
		bg.setThrowedPins(pins);
		assertThat(bg.tenFrame(10)).contains("X|X");
	}
	@Test
	public void 텐프레임_프레임_XXX() {
		bg.ballNum = 3;
		List<String> marks = new ArrayList<>();
		marks.add("X|X");
		List<Integer> pins = new ArrayList<>();
		pins.add(10);
		pins.add(0);
		pins.add(10);
		pins.add(0);
		bg.setMarks(marks);
		bg.setThrowedPins(pins);
		assertThat(bg.tenFrame(10)).contains("X|X|X");
	}
	@Test
	public void 텐프레임_X_스페어() {
		bg.ballNum = 3;
		List<String> marks = new ArrayList<>();
		marks.add("X|5");
		List<Integer> pins = new ArrayList<>();
		pins.add(10);
		pins.add(5);
		bg.setMarks(marks);
		bg.setThrowedPins(pins);
		assertThat(bg.tenFrame(5)).contains("X|5|/");
	}
	@Test
	public void 텐프레임_X_미스() {
		bg.ballNum = 3;
		List<String> marks = new ArrayList<>();
		marks.add("X|5");
		List<Integer> pins = new ArrayList<>();
		pins.add(10);
		pins.add(5);
		bg.setMarks(marks);
		bg.setThrowedPins(pins);
		assertThat(bg.tenFrame(4)).contains("X|5|4");
	}
	@Test
	public void 텐프레임_스페어_X() {
		bg.ballNum = 3;
		List<String> marks = new ArrayList<>();
		marks.add("2|/");
		List<Integer> pins = new ArrayList<>();
		pins.add(2);
		pins.add(8);
		bg.setMarks(marks);
		bg.setThrowedPins(pins);
		assertThat(bg.tenFrame(10)).contains("2|/|X");
	}
	@Test
	public void 텐프레임_스페어_미스() {
		bg.ballNum = 3;
		List<String> marks = new ArrayList<>();
		marks.add("5|/");
		List<Integer> pins = new ArrayList<>();
		pins.add(5);
		pins.add(5);
		bg.setMarks(marks);
		bg.setThrowedPins(pins);
		assertThat(bg.tenFrame(5)).contains("5|/|5");
	}
	@Test
	public void 텐프레임_미스() {
		bg.ballNum = 2;
		List<String> marks = new ArrayList<>();
		marks.add("2");
		List<Integer> pins = new ArrayList<>();
		pins.add(2);
		bg.setMarks(marks);
		bg.setThrowedPins(pins);
		assertThat(bg.tenFrame(2)).contains("2|2");
	}
	@Test
	public void 텐프레임_스페어() {
		bg.ballNum = 2;
		List<String> marks = new ArrayList<>();
		marks.add("2");
		List<Integer> pins = new ArrayList<>();
		pins.add(2);
		bg.setMarks(marks);
		bg.setThrowedPins(pins);
		assertThat(bg.tenFrame(8)).contains("2|/");
	}
	@Test
	public void 미스() {
		bg.ballNum = 2;
		List<String> marks = new ArrayList<>();
		marks.add("2");
		List<Integer> pins = new ArrayList<>();
		pins.add(2);
		bg.setMarks(marks);
		bg.setThrowedPins(pins);
		assertThat(bg.normalFrame(2)).contains("2|2");
	}
	@Test
	public void 스페어() {
		bg.ballNum = 2;
		List<String> marks = new ArrayList<>();
		marks.add("2");
		List<Integer> pins = new ArrayList<>();
		pins.add(2);
		bg.setMarks(marks);
		bg.setThrowedPins(pins);
		assertThat(bg.normalFrame(8)).contains("2|/");
	}
	@Test
	public void 스트라이크() {
		assertThat(bg.normalFrame(10)).contains("X");
	}
	@Test
	public void 제로() {
		assertThat(bg.normalFrame(0)).contains("-");
	}
}
