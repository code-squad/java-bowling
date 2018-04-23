package view;

import status.State;

import java.util.List;

public class ResultView {
    public static void upperBar(List<State> states , String name, int j) {
        System.out.println("| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |");
        underBar(states, name, j);
        System.out.println();
    }

    public static void underBar(List<State> states , String name, int j) {
        System.out.print("|  " + name +" |");
        for (State state : states) {
            System.out.print(state.displayText());
        }

//        for (int i = 0; i < 10 - j; i++)
//            System.out.print("      |");
    }
}
