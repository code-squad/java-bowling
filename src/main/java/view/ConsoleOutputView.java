package view;

import domain.Frame;
import domain.LastFrame;

public class ConsoleOutputView {

    public static void printInitScoreboard(String name) {
        System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
        System.out.println("|  " + name + " |      |      |      |      |      |      |      |      |      |      |");
    }

    public static void printScoreboard(Frame frame, String name) {
        System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
        StringBuilder bowlingScore = new StringBuilder();
        bowlingScore.append("|  " + name + " ");

        for (int i = 0; i < 10; i++) {
            bowlingScore.append(convertFirstRollToDrawing(frame));
            bowlingScore.append(convertSecondRollToDrawing(frame));
            if (frame.getFrameNo() == 10 && !((LastFrame) frame).isBonusRollNull()) {
                if (frame.getSecondRoll() == 10) {
                    bowlingScore.replace(77, 79, convertContinuousStrikeToDrawing((LastFrame) frame));
                    break;
                }
                bowlingScore.replace(76, 77, convertBonusRollToDrawing((LastFrame) frame));
                break;
            }
            frame = frame.getNextFrame();
        }
        bowlingScore.append("|");
        System.out.println(bowlingScore);
        System.out.println();
    }

    private static String convertFirstRollToDrawing(Frame frame) {
        if (frame.isFirstRollNull()) {
            return "|   ";
        }
        int firstRoll = frame.getFirstRoll();
        // 스트라이크
        if (firstRoll == 10) {
            return "|  X";
        }
        // 그 외
        return "|  " + firstRoll + "";
    }


    private static String convertSecondRollToDrawing(Frame frame) {
        if (frame.isSecondRollNull()) {
            return "   ";
        }

        int secondRoll = frame.getSecondRoll();
        // 스트라이크
        if (secondRoll == 10) {
            return "|10";
        }
        // 스페어
        if (frame.getFrameScore() == 10) {
            return "|/ ";
        }
        // 아무것도 못 넘어 트린 경우
        if (secondRoll == 0) {
            return "|- ";
        }
        // 그 외
        return "|" + secondRoll + " ";
    }

    private static String convertBonusRollToDrawing(LastFrame frame) {
        return "|" + frame.getBonusRoll() + "";
    }

    private static String convertContinuousStrikeToDrawing(LastFrame frame) {
        if (frame.getBonusRoll() == 10) {
            return "" + frame.getBonusRoll() + "";
        }
        return "|" + frame.getBonusRoll() + "";
    }
}