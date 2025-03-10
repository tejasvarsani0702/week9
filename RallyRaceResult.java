import java.util.ArrayList;
import java.util.List;

public class RallyRaceResult implements RaceResult {
    private String raceName;
    private List<Driver> results;
    private List<Integer> racePoints; // Store points earned in this race

    public RallyRaceResult(String raceName) {
        this.raceName = raceName;
        this.results = new ArrayList<>();
        this.racePoints = new ArrayList<>();
    }

    @Override
    public void recordResult(Driver driver, int position) {
        int points = calculatePoints(position);
        driver.addPoints(points); // Add points to the driver's total
        results.add(driver); // Add driver to the results
        racePoints.add(points); // Store points earned in this race
    }

    @Override
    public List<Driver> getResults() {
        return results;
    }

    public List<Integer> getRacePoints() {
        return racePoints;
    }

    private int calculatePoints(int position) {
        switch (position) {
            case 1: return 25;
            case 2: return 18;
            case 3: return 15;
            case 4: return 12;
            default: return 0;
        }
    }

    public String getRaceName() {
        return raceName;
    }
}