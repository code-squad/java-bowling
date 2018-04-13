package domain;

abstract class Frame implements Throwable {
    private Integer firstPins;
    private Integer secondPins;
    private Status status;

    static final int TEN_PINS = 10;
    static final int NO_PINS = 0;
    private Player player;

    Frame (String name) {
        player = new Player(name);
    }


}
