package rules;
import model.CarObservation;
import model.Violation;
import java.util.Optional;

public interface Rule {
    Optional<Violation> evaluate(CarObservation observation);
}