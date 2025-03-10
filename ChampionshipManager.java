import java.util.ArrayList;
import java.util.List;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers;
    private List<RallyRaceResult> raceResults;

    private ChampionshipManager() {
        drivers = new ArrayList<>();
        raceResults = new ArrayList<>();
    }

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void recordRaceResult(RallyRaceResult result) {
        raceResults.add(result);
    }

    public List<Driver> getChampionshipStandings() {
        drivers.sort((d1, d2) -> Integer.compare(d2.getTotalPoints(), d1.getTotalPoints()));
        return drivers;
    }

    public Driver getLeadingDriver() {
        return getChampionshipStandings().get(0);
    }

    public int calculateTotalChampionshipPoints() {
        return drivers.stream().mapToInt(Driver::getTotalPoints).sum();
    }

    public List<RallyRaceResult> getRaceResults() {
        return raceResults;
    }
}