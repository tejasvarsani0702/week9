import java.util.List;

public interface RaceResult {
    void recordResult(Driver driver, int position);
    List<Driver> getResults();
}