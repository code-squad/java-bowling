package view;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import frame.Frame;
import frame.NormalFrame;
import frame.StrikeLastFrame;
import state.Strike;

public class OutputScoreTest {
	Frame frame;
	String name = "NSG";

	@Before
	public void setting() {
		frame = new NormalFrame();
	}

	@Test
	public void test_method_printScoreboard_allFrame() {
		for (int i = 0; i < 20; i++) {
			frame.roll(4);
		}
		OutputScore.printFrameInfo(frame, name);
	}

	@Test
	public void test_method_printScoreboard() {
		for (int i = 0; i < 11; i++) {
			frame.roll(4);
		}
		OutputScore.printFrameInfo(frame, name);
	}
	
	@Test
	public void test_method_printScoreboard_lastFrame() {
		for (int i = 0; i < 9; i++) {
			frame.roll(10);
		}
		frame.roll(10);
		
//		frame.roll(5);
//		frame.roll(5);
		frame.roll(10);
		frame.roll(10);
		OutputScore.printFrameInfo(frame, name);
	}

//	@Test
//	public void test_method_printTotalScoreBoard_Frame_Test() {
//		frame.roll(5);
//		frame.roll(4);
//		frame.roll(4);
//		frame.roll(3);
//		frame.roll(7);
//		OutputScore.printTotalScoreBoard(frame);
//	}
//	
//	@Test
//	public void test_method_printTotalScoreBoard_SpareFrame_Test() {
//		frame.roll(5);
//		frame.roll(5);
//		frame.roll(4);
//		frame.roll(6);
//		frame.roll(7);
//		OutputScore.printTotalScoreBoard(frame);
//	}
//
//	@Test
//	public void test_method_printTotalScoreBoard_SpareLastFrame_Test() {
//		for (int i = 0; i < 9; i++) {
//			frame.roll(10);
//		}
//		frame.roll(5);
//		frame.roll(5);
//		
//		frame.roll(5);
//		OutputScore.printTotalScoreBoard(frame);
//	}
//	
//	@Test
//	public void test_method_printTotalScoreBoard_StrikeLastFrame_Test() {
//		for (int i = 0; i < 10; i++) {
//			frame.roll(10);
//		}
//		frame.roll(10);
//		frame.roll(10);
//		OutputScore.printTotalScoreBoard(frame);
//	}
//	
//	@Test
//	public void test_method_printTotalScoreBoard_StrikeLastFrame_Spare_Test() {
//		for (int i = 0; i < 10; i++) {
//			frame.roll(10);
//		}
//		frame.roll(5);
//		frame.roll(5);
//		OutputScore.printTotalScoreBoard(frame);
//	}
	
	@Test
	public void test_method_printTotalScoreBoard_Strike_Test() {
		frame.roll(10);
		
		frame.roll(5);
		frame.roll(4);
		
		frame.roll(5);
		frame.roll(5);
		
		frame.roll(4);
		frame.roll(6);
		
		frame.roll(10);
		
		frame.roll(10);
		
		frame.roll(10);
		
		frame.roll(6);
		frame.roll(3);
		
		frame.roll(4);
		frame.roll(4);
		
		frame.roll(10);
		
		frame.roll(10);
		frame.roll(10);
		OutputScore.printFrameInfo(frame, name);
	}
}
