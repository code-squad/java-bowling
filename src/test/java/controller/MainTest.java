package controller;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class MainTest {
	Main main;
	@Before
	public void setUp() {
		main = new Main();
	}
	@Test
	public void createStatus테스트() throws Exception {
		
		int falledPin = 9;
		String status1 = main.createStatus(falledPin);
		assertEquals("9", status1);
		int falledPin1 = 1;
		String status2 = main.createStatus(falledPin1);
		assertEquals("9|/", status2);
		
		int falledPin2 = 8;
		String status3 = main.createStatus(falledPin2);
		assertEquals("8", status3);
		int falledPin3 = 0;
		String status4 = main.createStatus(falledPin3);
		assertEquals("8|-", status4);
		
		int falledPin4 = 10;
		String status5 = main.createStatus(falledPin4);
		assertEquals("X", status5);
	}
	@Test
	public void create1stFrameTest() throws Exception {
		int falledPin1= 9;
		Map firstFrame1 = main.createFirstFrame(falledPin1);
		assertEquals("9", firstFrame1.get(1));
	
		int falledPin2 = 1;
		Map firstFrame2 = main.createFirstFrame(falledPin2);
		assertEquals("9|/", firstFrame2.get(1));

	}
	
	@Test
	public void createNextFrameTest() throws Exception {
		int falledPin1= 9;
		List<Map <Integer, String>> firstFrame1 = main.createNextFrameOrNot(falledPin1);
		assertEquals("9", main.getFrames().get(0).get(1));
		assertTrue(main.getFrames().size() == 1);
		
		int falledPin2 = 1;
		List<Map <Integer, String>> firstFrame2 = main.createNextFrameOrNot(falledPin2);
		assertEquals("9|/", main.getFrames().get(0).get(1));
		assertEquals(1, main.getFrames().size());	
		assertEquals(2, Main.frameNum);
		

		int falledPin3 = 10;
		List<Map <Integer, String>> secondFrame = main.createNextFrameOrNot(falledPin3);
		assertEquals(2, secondFrame.size());	
		assertEquals("X", main.getFrames().get(1).get(2));
		assertEquals(2, main.getFrames().size());	
		
		int falledPin4 = 2;
		List<Map <Integer, String>> thirdFrame1 = main.createNextFrameOrNot(falledPin4);
		assertEquals("2", main.getFrames().get(2).get(3));
		assertEquals(3, main.getFrames().size());	
		
		int falledPin5 = 5;
		List<Map <Integer, String>> thirdFrame2 = main.createNextFrameOrNot(falledPin5);
		assertEquals("2|5", main.getFrames().get(2).get(3));
		assertEquals(3, main.getFrames().size());	


	}
	@Test
	public void createFramesTest() throws Exception {
		int falledPin1 = 9;
		List<Map<Integer, String>> frames = main.createFrames(falledPin1);
		assertTrue(frames.size() == 1);
		assertEquals("9", frames.get(0).get(1));
		
		int falledPin2 = 1;
		frames = main.createFrames(falledPin2);
		assertTrue(frames.size() == 1);
		assertEquals("9|/", frames.get(0).get(1));
	}
	@Test
	public void createNextFrameOrNot() throws Exception {
		int falledPin1 = 9;
		Map<Integer, String> firstFrame = main.createNextFrameOrNot(falledPin1);
		assertEquals("9", firstFrame.get(1));
		assertEquals(1, main.getFrames().size());
		int falledPin2 = 1;
		int falledPin3 = 10;
	}
	@Test
	public void 번째_프레임_상태_생성_테스트() throws Exception {
		int[] pins1 = {10};
		String status1 = main.createStatusFor10thFrame(pins1);
		assertEquals("X", status1);
			
		int[] pins2 = {2};
		String status2 = main.createStatusFor10thFrame(pins2);
		assertEquals("2", status2);
		
		int[] pins3 = {10, 2, 8};
		String status3 = main.createStatusFor10thFrame(pins3);
		assertEquals("X" + "2|/", status3);
		
		int[] pins4 = {10, 2, 4};
		String status4 = main.createStatusFor10thFrame(pins4);
		assertEquals("X" + "2|4", status4);
		
		int[] pins5 = {2, 8, 1};
		String status5 = main.createStatusFor10thFrame(pins5);
		assertEquals("2|/" + "1", status5);
		
		int[] pins6 = {2, 8, 10};
		String status6 = main.createStatusFor10thFrame(pins6);
		assertEquals("2|/" + "X", status6);
	}
	@Test
	public void createTenthFrame() throws Exception {
		int falledPin1 = 10;
		main.createTenthFrame(falledPin1);
		assertEquals("X", main.getFrames().get(9).get(10));
		
		int falledPin2 = 2;
		main.createTenthFrame(falledPin2);
		assertEquals("X" + "2", main.getFrames().get(9).get(10));
	}
}
