package view;

import domain.Frame;
import domain.NormalFrame;

import java.util.Scanner;

public class ConsoleMain {

    /**
     * 볼링 게임 규칙
     * 1. 볼링 게임은 10개의 프레임으로 구성
     * 2. 각 프레임은 2번의 기회를 가짐
     * 3. spare: 10 + next first roll에서 쓰러트린 핀수
     * 4. strike: 10 + next two roll에서 쓰러트린 핀수
     * 5. 마지막 프레임은 특별히 spare처리하면 3번 던질 수 있음
     */

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            String name = ConsoleInputView.getPlayerName(sc);
            ConsoleOutputView.printInitScoreboard(name);
            Frame frame = new NormalFrame(1);

            while (!frame.getCurrentFrame().isEndGame()) {
                frame.roll(ConsoleInputView.enterScore(sc, frame.getCurrentFrameNo()));
                ConsoleOutputView.printScoreboard(frame, name);
            }
            sc.close();
        } catch (Exception e) {
        }
    }
}
