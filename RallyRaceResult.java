package week9;

import java.util.HashMap;
import java.util.Map;

public class RallyRaceResult {

    // Nested RaceResult interface
    public interface RaceResult {
        void recordResult(Driver driver, int position, int points);
        Map<Driver, Integer> getResults();
    }

    // Implementation of the RaceResult interface
    private Map<Driver, Integer> results;

    public RallyRaceResult() {
        results = new HashMap<>();
    }

    public void recordResult(Driver driver, int position, int points) {
        results.put(driver, points);
        driver.addPoints(points);
    }

    public Map<Driver, Integer> getResults() {
        return results;
    }
}