package view;

import frame.Frame;
import status.Status;

import java.util.List;

public class ResultView {
    public static void upperBar(List<Status> statuses , String name) {
        System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
        underBar(statuses, name);
        System.out.println();
    }

    public static void underBar(List<Status> statuses , String name) {
        System.out.print("|  " + name +" |");
        for (Status status : statuses) {
            System.out.print(status.toString());
            System.out.print("|");
        }
//        for (int i = 0; i < 10 - frames.size(); i++)
//            System.out.print("      |");
    }
}
