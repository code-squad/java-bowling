package view;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class InputScoreTest {
	private Scanner scan;

	@Before
	public void setting() {
	}

	@Test
	public void game_start_console_view_test() {
		scan = new Scanner(System.in);
		String name = InputScore.bowlingGameStart(scan);
		assertThat(name, is("ABC"));
	}

//	@Test
//	public void input_score_test() {
//		scan = new Scanner(System.in);
//		int score = InputScore.inputScore(scan, 1);
//		assertThat(score, is(5));
//	}
}
