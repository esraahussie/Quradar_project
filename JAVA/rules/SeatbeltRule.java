package rules;
import model.CarObservation;
import model.Violation;
import java.util.Optional;

public class SeatbeltRule implements Rule {
    private final double fee;
    public SeatbeltRule(double fee) {
        this.fee = fee;
    }
    @Override
    public Optional<Violation> evaluate(CarObservation observation) {
        if (!observation.isSeatbeltFastened()) {
            return Optional.of(new Violation("Seatbelt not fastened", fee));
        }
        return Optional.empty();
    }
}