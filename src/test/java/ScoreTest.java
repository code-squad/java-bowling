import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ScoreTest {

	@Test
	public void getFirstScoreTest() {
		String stringScore = "10";
		List<String> score = Arrays.asList(" "," ","X"," "," "," ","|");
		assertEquals(score, Score.getFirstScore(stringScore));
		
		stringScore = "0";
		score = Arrays.asList(" "," ","-"," "," "," ","|");
		assertEquals(score, Score.getFirstScore(stringScore));
		
		stringScore = "5";
		score = Arrays.asList(" "," ","5"," "," "," ","|");
		assertEquals(score, Score.getFirstScore(stringScore));
	}
	
	@Test
	public void getSecondScoreTest() {
		String firstScore = "4";
		String secondScore = "5";
		List<String> score = Arrays.asList(" "," ","4","|","5"," ","|");
		assertEquals(score, Score.getSecondScore(firstScore, secondScore));
		
		firstScore = "4";
		secondScore = "6";
		score = Arrays.asList(" "," ","4","|","/"," ","|");
		assertEquals(score, Score.getSecondScore(firstScore, secondScore));
	}

}
