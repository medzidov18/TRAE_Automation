package dataread;

public enum StatusCodes {
    OK_200(200),
    OK_204(204),
    ERROR_401(401);

    private final int value;

    private StatusCodes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
