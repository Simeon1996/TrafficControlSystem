package system.traffic;

public enum LightDuration {
    RED(10),
    YELLOW(2),
    GREEN(5);

    private int value;

    /**
     * An indicator of how much a certain light will be on focus
     *
     * @param value in seconds
     */
    LightDuration(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
