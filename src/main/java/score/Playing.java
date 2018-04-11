package score;

import java.util.Random;

public class Playing {
    private Random rnd;

    public Playing() {
        rnd = new Random();
    }

    public Integer makeRandomNum() {
        return rnd.nextInt(11);
    }

    public Integer shot(int rndNum) {
        if (rndNum == 10) {
            System.out.println("스트라이크");
            return rndNum;
        }
        System.out.println("first pin is " + rndNum);
        return rndNum;
    }

    public Integer secondshot(int firstPin) {
        int secondpin = rnd.nextInt(11 - firstPin);
        if (secondpin == (10 - firstPin)) {
            System.out.println("스페어");
            return secondpin;
        }
        System.out.println("secondPin is " + secondpin);
        return secondpin;
    }
}
