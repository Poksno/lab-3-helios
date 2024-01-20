package enums;

public enum RocketStatus {
    ON_GROUND(1), TAKING_OFF(2), IN_FLIGHT(3), LANDING(4);

    private final int statusNumber;

    RocketStatus(int statusNumber) {
        this.statusNumber = statusNumber;
    }

    public int getStatusNumber() {
        return this.statusNumber;
    }

}
