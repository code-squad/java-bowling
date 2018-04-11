package score;

public class Playing {
    public Integer shot(int firstNum) {
        if (firstNum == 10) {
            System.out.println("스트라이크");
            return firstNum;
        }
        System.out.println("첫번째 맞춘갯수 : " + firstNum);
        return firstNum;
    }

    public Integer secondshot(int firstNum ,int secondNum) {
        System.out.println("남은갯수 : " + (10 - firstNum));
        if (secondNum == (10 - firstNum)) {
            System.out.println("스페어");
            return secondNum;
        }
        System.out.println("두번째 맞춘 갯수 : " + secondNum);
        return secondNum;
    }
}
