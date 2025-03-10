public class Driver {
    private String name;
    private String country;
    private int totalPoints;
    private RallyCar car;

    public Driver(String name, String country, RallyCar car) {
        this.name = name;
        this.country = country;
        this.car = car;
        this.totalPoints = 0;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void addPoints(int points) {
        this.totalPoints += points;
    }

    public RallyCar getCar() {
        return car;
    }

    public void setCar(RallyCar car) {
        this.car = car;
    }
}