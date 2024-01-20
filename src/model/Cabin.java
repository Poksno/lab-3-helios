package model;

public class Cabin {
    private Traveler[] travelers;

    public Cabin(Traveler[] travelers) {
        this.travelers = travelers;
    }

    public Traveler[] getTravelers() {
        return travelers;
    }

    public void setTravelers(Traveler[] travelers) {
        this.travelers = travelers;
    }
}
