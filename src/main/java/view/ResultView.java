//package view;
//
//import frame.Frame;
//import game.Result;
//import status.Status;
//
//import java.util.List;
//
//public class ResultView {
//    public static void upperBar(List<Result> results , String name, int j) {
//        System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
//        underBar(results, name, j);
//        System.out.println();
//    }
//
//    public static void underBar(List<Result> results , String name, int j) {
//        System.out.print("|  " + name +" |");
//        for (Result result : results) {
//            System.out.print(result.getStatus().toString());
//            System.out.print("|");
//        }
//        for (int i = 0; i < 10 - j; i++)
//            System.out.print("      |");
//    }
//}

package view;

import status.State;

import java.util.List;

public class ResultView {
    public static void upperBar(List<State> states , String name, int j) {
        System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
        underBar(states, name);
        System.out.println();
    }

    public static void underBar(List<State> states , String name) {
        System.out.print("|  " + name +" |");
        for (State state : states) {
            System.out.print(state.displayText());
//            System.out.print("|");
        }
    }
}
