import java.util.List;

public class Main {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        RallyCar gravelCar = new GravelCar("Toyota", "Yaris", 300);
        RallyCar asphaltCar = new AsphaltCar("Hyundai", "i20", 320);

        Driver driver1 = new Driver("Sébastien Ogier", "France", gravelCar);
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland", asphaltCar);
        Driver driver3 = new Driver("Ott Tänak", "Estonia", gravelCar);
        Driver driver4 = new Driver("Thierry Neuville", "Belgium", asphaltCar);

        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);
        manager.registerDriver(driver4);

        RallyRaceResult race1 = new RallyRaceResult("Rally Finland (Jyväskylä)");
        race1.recordResult(driver1, 1);
        race1.recordResult(driver3, 2);
        race1.recordResult(driver2, 3);
        race1.recordResult(driver4, 4);

        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally (Monaco)");
        race2.recordResult(driver2, 1);
        race2.recordResult(driver4, 2);
        race2.recordResult(driver1, 3);
        race2.recordResult(driver3, 4);

        manager.recordRaceResult(race1);
        manager.recordRaceResult(race2);

        List<Driver> standings = manager.getChampionshipStandings();
        System.out.println("===== CHAMPIONSHIP STANDINGS ====");
        for (Driver driver : standings) {
            System.out.println(driver.getName() + " (" + driver.getCountry() + "): " + driver.getTotalPoints() + " points");
        }

        Driver leader = manager.getLeadingDriver();
        System.out.println("\n===== CHAMPIONSHIP LEADER ====");
        System.out.println(leader.getName() + " with " + leader.getTotalPoints() + " points");

        System.out.println("\n===== CHAMPIONSHIP STATISTICS ====");
        System.out.println("Total Drivers: " + manager.getChampionshipStandings().size());
        System.out.println("Total Races: " + ChampionshipStatistics.countTotalRaces(manager.getRaceResults()));
        System.out.println("Average Points Per Driver: " + String.format("%.2f", ChampionshipStatistics.calculateAveragePointsPerDriver(manager.getChampionshipStandings())));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(manager.getChampionshipStandings()));
        System.out.println("Total Championship Points: " + manager.calculateTotalChampionshipPoints());

        System.out.println("\n===== RACE RESULTS ====");
        for (RallyRaceResult result : manager.getRaceResults()) {
            System.out.println("Race: " + result.getRaceName());
            List<Driver> results = result.getResults();
            List<Integer> racePoints = result.getRacePoints();
            for (int i = 0; i < results.size(); i++) {
                System.out.println("    Position " + (i + 1) + ": " + results.get(i).getName() + " - " + racePoints.get(i) + " points");
            }
        }

        System.out.println("\n===== CAR PERFORMANCE RATINGS ====");
        System.out.println("Gravel Car Performance: " + gravelCar.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphaltCar.calculatePerformance());
    }
}