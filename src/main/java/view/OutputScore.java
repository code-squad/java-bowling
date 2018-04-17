package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bowling.FrameInfo;
import frame.Frame;
import frame.NormalFrame;
import frame.StrikeLastFrame;

public class OutputScore {
	private static final Logger log = LoggerFactory.getLogger(OutputScore.class);

	public static void printFrameInfo(Frame frame, String name) {
		List<FrameInfo> frameInfoList = frame.getFrameInfo(new ArrayList<>());
		Iterator<FrameInfo> iter = frameInfoList.iterator();
		int total = 0;
		
		while (iter.hasNext()) {
			FrameInfo frameInfo = iter.next();
			System.out.println(frameInfo.getFrameNo());
			if (!frameInfo.isFirstRollNull()) {
				System.out.println("firstRoll");
				System.out.println(frameInfo.getFirstRoll());
			}
			
			if (!frameInfo.isSecondRollNull()) {
				System.out.println("secondRoll");
				System.out.println(frameInfo.getSecondRoll());
			}
			
			if (!frameInfo.isTotalScoreNull()) {
				System.out.println("total");
				total += frameInfo.getTotalScore().getScore();
				System.out.println(total);
			}
		}
		
		
	}

	// public static void printFrameInfo(Frame frame, String name) {
	// printScoreboard(frame, name);
	// printTotalScoreBoard(frame);
	// }
	//
	// static void printScoreboard(Frame frame, String name) {
	// System.out.println("| NAME | 01 | 02 | 03 | 04 | 05 | 06 | 07 | 08 | 09 | 10
	// |");
	// StringBuilder bowlingScore = new StringBuilder("");
	// bowlingScore.append("| " + name + " ");
	//
	// for (int i = 0; i < frame.getFrameInfo().getFrameNo(); i++) {
	// FrameInfo frameInfo = frame.getFrameInfo();
	// bowlingScore.append(convertFirstRollToString(frameInfo));
	// bowlingScore.append(convertSecondRollToString(frameInfo));
	//
	// if (frameInfo.getNextFrame() != null && frameInfo.getFrameNo() != 9) {
	// frame = frameInfo.getNextFrame();
	// }
	// }
	//
	// if (frame.getFrameInfo().getFrameNo() == 9) {
	//
	// if (frame.getFrameInfo().getNextFrame() == null) {
	// FrameInfo frameInfo = frame.getFrameInfo();
	// bowlingScore.append(convertFirstRollToString(frameInfo));
	// bowlingScore.append(convertSecondRollToString(frameInfo));
	// }
	//
	// while (frame.getFrameInfo().getNextFrame() != null) {
	// frame = frame.getFrameInfo().getNextFrame();
	//
	// if (frame instanceof NormalFrame) {
	// bowlingScore.append(convertLastFirstRollToString(frame.getFrameInfo()));
	// if (!frame.getFrameInfo().isSecondRollNull()) {
	// bowlingScore.append(convertBonusSecondRollToString(frame.getFrameInfo()));
	// }
	// }
	//
	// if (!(frame instanceof NormalFrame)) {
	// bowlingScore.append(convertBonusRollToString(frame.getFrameInfo()));
	// if (!frame.getFrameInfo().isSecondRollNull()) {
	// bowlingScore.append(convertBonusSecondRollToString(frame.getFrameInfo()));
	// }
	// }
	// }
	// }
	//
	// for (int i = 0; i < 10 - frame.getFrameInfo().getFrameNo(); i++) {
	// bowlingScore.append("| ");
	// }
	// bowlingScore.append("|");
	// System.out.println(bowlingScore);
	// }
	//
	// private static String convertFirstRollToString(FrameInfo frameInfo) {
	// if (frameInfo.isFirstRollNull()) {
	// return "| ";
	// }
	//
	// int firstRoll = frameInfo.getFirstRoll();
	//
	// if (firstRoll == 10) {
	// return "| X";
	// }
	// return "| " + firstRoll + "";
	// }
	//
	// private static String convertSecondRollToString(FrameInfo frameInfo) {
	// if (frameInfo.isSecondRollNull()) {
	// return " ";
	// }
	//
	// int secondRoll = frameInfo.getSecondRoll();
	//
	// if (secondRoll == 10) {
	// return "|10";
	// }
	//
	// if (frameInfo.getFrameScore() == 10) {
	// return "|/ ";
	// }
	//
	// if (secondRoll == 0) {
	// return "|- ";
	// }
	// return "|" + secondRoll + " ";
	// }
	//
	// private static String convertLastFirstRollToString(FrameInfo frameInfo) {
	// if (frameInfo.isFirstRollNull()) {
	// return "| ";
	// }
	//
	// int firstRoll = frameInfo.getFirstRoll();
	//
	// if (firstRoll == 10) {
	// return "| X";
	// }
	// return "| " + firstRoll + "";
	// }
	//
	// private static String convertBonusSecondRollToString(FrameInfo frameInfo) {
	// int secondRoll = frameInfo.getSecondRoll();
	//
	// if (frameInfo.getFrameScore() == 10) {
	// return "|/";
	// }
	// return "|" + secondRoll + "";
	// }
	//
	// private static Object convertBonusRollToString(FrameInfo frameInfo) {
	// int firstRoll = frameInfo.getFirstRoll();
	//
	// if (firstRoll == 10) {
	// return "|X";
	// }
	// return "|" + firstRoll + "";
	// }
	//
	// static void printTotalScoreBoard(Frame frame) {
	// StringBuilder bowlingTotalScore = new StringBuilder("");
	// bowlingTotalScore.append("| ");
	// int totalScore = 0;
	//
	// for (int i = 0; i < frame.getFrameInfo().getFrameNo(); i++) {
	// FrameInfo frameInfo = frame.getFrameInfo();
	// if (!frameInfo.getState().isFrameEnd()) {
	// bowlingTotalScore.append("| ");
	// }
	//
	// if (frameInfo.getState().isFrameEnd()) {
	// if (frameInfo.getNextFrame() != null && frameInfo.getTotalScore() == null) {
	// bowlingTotalScore.append("| ");
	// }
	//
	// if (frameInfo.getNextFrame() != null && frameInfo.getTotalScore() != null) {
	// totalScore += frameInfo.getTotalScore().getScore();
	// bowlingTotalScore.append(convertTotalToString(totalScore));
	// }
	// }
	//
	// if (frameInfo.getNextFrame() != null) {
	// frame = frameInfo.getNextFrame();
	// }
	// }
	//
	// for (int i = 0; i < 10 - frame.getFrameInfo().getFrameNo(); i++) {
	// bowlingTotalScore.append("| ");
	// }
	// bowlingTotalScore.append("|");
	// System.out.println(bowlingTotalScore);
	// }
	//
	// private static String convertTotalToString(int totalScore) {
	// if (totalScore >= 100) {
	// return "| " + totalScore + " ";
	// }
	//
	// if (totalScore < 10) {
	// return "| " + totalScore + " ";
	// }
	// return "| " + totalScore + " ";
	// }

}
