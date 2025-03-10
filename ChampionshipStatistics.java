import java.util.List;

public class ChampionshipStatistics {
    public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
        return drivers.stream().mapToInt(Driver::getTotalPoints).average().orElse(0);
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        // Implementation to find the most successful country
        return "Finland"; // Placeholder
    }

    public static int countTotalRaces(List<RallyRaceResult> raceResults) {
        return raceResults.size();
    }
}