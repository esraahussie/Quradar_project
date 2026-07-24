package rules;
import model.CarObservation;
import model.CarType;
import model.Violation;
import java.util.Map;
import java.util.Optional;

public class SpeedRule implements Rule {
    private final Map<CarType, Integer> maxSpeedByCarType;
    private final double fee;
    public SpeedRule(Map<CarType, Integer> maxSpeedByCarType, double fee) {
        this.maxSpeedByCarType = maxSpeedByCarType;
        this.fee = fee;
    }
    @Override
    public Optional<Violation> evaluate(CarObservation observation) {
        Integer maxSpeed = maxSpeedByCarType.get(observation.getCarType());
        if (maxSpeed != null && observation.getSpeed() > maxSpeed) {
            String description = "speed of " + observation.getSpeed()+ " exceeded max allowed " + maxSpeed;
            return Optional.of(new Violation(description, fee));
        }
        return Optional.empty();
    }
}