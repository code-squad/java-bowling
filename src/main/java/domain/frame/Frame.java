package domain.frame;

/*
    1. 프레임 종류별로 어떻게 다른지 생각해보기
    - 노말 프레임
    - 라스트 프레임

    2. status, scores를 각각 어떻게 활용할지
 */
public interface Frame {

    void addScore(int score) throws IllegalArgumentException;

    boolean isFinish();
}
