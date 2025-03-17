package week9;

import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        // Create ChampionshipManager singleton
        ChampionshipManager manager = ChampionshipManager.getInstance();

        // Create drivers and cars
        RallyCar gravelCar1 = new GravelCar("Toyota", "Yaris", 300);
        RallyCar asphaltCar1 = new AsphaltCar("Hyundai", "i20", 320);

        Driver driver1 = new Driver("Sébastien Ogier", "France", gravelCar1);
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland", asphaltCar1);
        Driver driver3 = new Driver("Ott Tänak", "Estonia", gravelCar1);
        Driver driver4 = new Driver("Thierry Neuville", "Belgium", asphaltCar1);

        // Register drivers
        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);
        manager.registerDriver(driver4);

        // Simulate races
        RallyRaceResult race1 = new RallyRaceResult();
        race1.recordResult(driver1, 1, 25);
        race1.recordResult(driver3, 2, 18);
        race1.recordResult(driver2, 3, 15);
        race1.recordResult(driver4, 4, 12);
        manager.recordRaceResult(race1);

        RallyRaceResult race2 = new RallyRaceResult();
        race2.recordResult(driver2, 1, 25);
        race2.recordResult(driver4, 2, 18);
        race2.recordResult(driver1, 3, 15);
        race2.recordResult(driver3, 4, 12);
        manager.recordRaceResult(race2);

        // Display championship standings
        System.out.println("===== CHAMPIONSHIP STANDINGS =====");
        List<Driver> standings = manager.getChampionshipStandings();
        for (Driver driver : standings) {
            System.out.println(driver.getName() + " (" + driver.getCountry() + "): " + driver.getTotalPoints() + " points");
        }

        // Display championship leader
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        Driver leader = manager.getLeadingDriver();
        System.out.println(leader.getName() + " with " + leader.getTotalPoints() + " points");

        // Display championship statistics
        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipStatistics.countTotalRaces());
        System.out.println("Average Points Per Driver: " + ChampionshipStatistics.calculateAveragePoints(standings));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(standings));
        System.out.println("Total Championship Points: " + manager.calculateTotalChampionshipPoints());

        // Display race results
        System.out.println("\n===== RACE RESULTS =====");
        for (RallyRaceResult result : manager.getRaceResults()) {
            System.out.println("Race Results:");
            for (Map.Entry<Driver, Integer> entry : result.getResults().entrySet()) {
                System.out.println(" - " + entry.getKey().getName() + ": " + entry.getValue() + " points");
            }
        }

        // Display car performance ratings
        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + gravelCar1.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphaltCar1.calculatePerformance());
    }
}