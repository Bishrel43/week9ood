package week9;

import java.util.List;
import java.util.Map;

public class ChampionshipStatistics {
    public static double calculateAveragePoints(List<Driver> drivers) {
        return drivers.stream().mapToInt(Driver::getTotalPoints).average().orElse(0);
    }

    public static String findMostSuccessfulCountry(List<Driver> drivers) {
        return drivers.stream()
                .collect(java.util.stream.Collectors.groupingBy(Driver::getCountry, java.util.stream.Collectors.summingInt(Driver::getTotalPoints)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No data");
    }

    public static int countTotalRaces() {
        return ChampionshipManager.getTotalRaces();
    }
}