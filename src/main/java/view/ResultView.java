package view;

import frame.Frame;

import java.util.List;

public class ResultView {
    public static void upperBar(List<Frame> frames, String name) {
        System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
        underBar(frames, name);
        System.out.println();
    }

    public static void underBar(List<Frame> frames, String name) {
        System.out.print("|  " + name +" |");
        for (Frame frame: frames) {
            frame.getResult();
            System.out.print("|");
        }

        for (int i = 0; i < 10 -frames.size(); i++)
            System.out.print("      |");
    }
}
